package com.qaverse.smart.trace.dashboard.widget;

import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureSummaryWidget {

	public WidgetData build(FailureRecord record) {

		WidgetData data = new WidgetData();

		data.setWidgetId("failure-summary-widget");

		data.setTitle("Failure Summary");

		data.setType("FAILURE_SUMMARY");

		data.put("failureId", record.getFailureId());

		data.put("traceId", record.getTraceId());

		data.put("testName", record.getTestName());

		data.put("exceptionType", record.getExceptionType());

		data.put("exceptionMessage", record.getExceptionMessage());

		return data;
	}
}