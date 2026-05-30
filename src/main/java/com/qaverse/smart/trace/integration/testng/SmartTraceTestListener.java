package com.qaverse.smart.trace.integration.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qaverse.smart.trace.core.SmartTraceEngine;
import com.qaverse.smart.trace.core.TraceBootstrap;
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
		if (engine == null) {

			System.err.println("[SMART-TRACE] Engine not initialized. " + "Call Trace.enable() before execution.");

			return;
		}
		engine = TraceBootstrap.getEngine();
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

		repository.save(investigation);

		StepTraceManager.clear();

		System.out.println("[SMART-TRACE] Investigation Generated : " + failureRecord.getFailureId());
	}
}