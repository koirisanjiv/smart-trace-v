package com.qaverse.smart.trace.workflow;

import java.util.List;

import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.FailureRecord;

public class WorkflowResult {

	private FailureRecord failureRecord;

	private List<WidgetData> widgets;

	public FailureRecord getFailureRecord() {
		return failureRecord;
	}

	public void setFailureRecord(FailureRecord failureRecord) {
		this.failureRecord = failureRecord;
	}

	public List<WidgetData> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<WidgetData> widgets) {
		this.widgets = widgets;
	}

}