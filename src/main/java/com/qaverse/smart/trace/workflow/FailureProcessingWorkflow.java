package com.qaverse.smart.trace.workflow;

import java.io.File;
import java.util.List;

import com.qaverse.smart.trace.dashboard.widget.FailureDashboardBuilder;
import com.qaverse.smart.trace.export.ExportFormat;
import com.qaverse.smart.trace.export.TraceExportManager;
import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.storage.FailureRepository;

public class FailureProcessingWorkflow {

	private final FailureRepository repository = new FailureRepository();

	private final FailureDashboardBuilder dashboardBuilder = new FailureDashboardBuilder();

	private final TraceExportManager exportManager = new TraceExportManager();

	public FailureRecord process(FailureRecord record) {

		repository.save(record);

		return record;
	}

	public List<WidgetData> buildDashboard(String failureId) {

		FailureRecord record = repository.find(failureId);

		if (record == null) {

			throw new IllegalArgumentException("Failure not found : " + failureId);
		}

		return dashboardBuilder.build(record);
	}

	public File exportJson(String failureId, String fileName) {

		FailureRecord record = repository.find(failureId);

		return exportManager.export(ExportFormat.JSON, fileName, record);
	}

	public File exportCsv(String failureId, String fileName) {

		FailureRecord record = repository.find(failureId);

		return exportManager.export(ExportFormat.CSV, fileName, record);
	}
}