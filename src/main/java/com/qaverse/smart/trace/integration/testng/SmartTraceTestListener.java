package com.qaverse.smart.trace.integration.testng;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qaverse.smart.trace.capture.ArtifactCaptureCoordinator;
import com.qaverse.smart.trace.core.SmartTraceEngine;
import com.qaverse.smart.trace.core.TraceBootstrap;
import com.qaverse.smart.trace.dashboard.html.SmartTraceDashboardGenerator;
import com.qaverse.smart.trace.debug.LocalInvestigationPrinter;
import com.qaverse.smart.trace.export.ExportFormat;
import com.qaverse.smart.trace.export.TraceExportManager;
import com.qaverse.smart.trace.model.failure.ArtifactRecord;
import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.storage.investigation.InvestigationRepository;
import com.qaverse.smart.trace.storage.investigation.InvestigationStore;
import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;
import com.qaverse.smart.trace.trace.step.StepTraceManager;
import com.qaverse.smart.trace.trace.step.StepTraceRecorder;
import com.qaverse.smart.trace.workflow.FailureRecordBuilder;
import com.qaverse.smart.trace.workflow.SmartTraceWorkflow;

public class SmartTraceTestListener implements ITestListener {

	private SmartTraceEngine engine;

	private final SmartTraceWorkflow workflow = new SmartTraceWorkflow();

	private final InvestigationRepository repository = InvestigationStore.getRepository();

	@Override
	public void onStart(ITestContext context) {

		engine = TraceBootstrap.getEngine();

		if (engine == null) {

			System.err.println("[SMART-TRACE] Engine not initialized. " + "Call Trace.enable() before execution.");
		}
	}

	@Override
	public void onTestStart(ITestResult result) {

		if (engine == null) {
			return;
		}

		StepTraceManager.startSession();

		engine.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if (engine == null) {
			return;
		}

		engine.passTest(result.getMethod().getMethodName());

		StepTraceManager.clear();
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (engine == null) {
			return;
		}

		engine.failTest(result.getMethod().getMethodName(), result.getThrowable());

		FailureRecord failureRecord = FailureRecordBuilder.build(result);

		StepTraceRecorder recorder = StepTraceManager.getRecorder();

		InvestigationRecord investigation = workflow.investigate(failureRecord, recorder);
		
		String projectName = TraceBootstrap.getOptions().getProjectName();

		ArtifactCaptureCoordinator coordinator = new ArtifactCaptureCoordinator();
		
		WebDriver driver = null;

		if (TraceBootstrap.getOptions() != null && TraceBootstrap.getOptions().getDriverProvider() != null) {
			driver = TraceBootstrap.getOptions().getDriverProvider().get();
		}

		ArtifactRecord artifacts = coordinator.capture(driver, failureRecord.getFailureId(),
				projectName);

		failureRecord.setArtifacts(artifacts);

		repository.save(investigation);

		// SearchValidation.validate();
		TraceExportManager exporter = new TraceExportManager();
		exporter.export(ExportFormat.JSON, "smart-trace/" + failureRecord.getFailureId() + ".json", failureRecord);

		System.out.println("[SMART-TRACE] Repository Count : " + repository.count());

		new LocalInvestigationPrinter().print(investigation);

		new SmartTraceDashboardGenerator().generate();

		StepTraceManager.clear();

		System.out.println("[SMART-TRACE] Investigation Generated : " + failureRecord.getFailureId());
	}

	@Override
	public void onFinish(ITestContext context) {

		StepTraceManager.clear();
	}
}