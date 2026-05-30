package com.qaverse.smart.trace.dashboard.widget;

import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.CorrelationRecord;
import com.qaverse.smart.trace.model.failure.FailureRecord;

public class CorrelationWidget {

	public WidgetData build(FailureRecord record) {

		WidgetData data = new WidgetData();

		data.setWidgetId("correlation-widget");

		data.setTitle("Failure Correlation");

		data.setType("CORRELATION");

		CorrelationRecord correlation = record.getCorrelation();

		if (correlation != null) {

			data.put("confidence", correlation.getConfidence());

			data.put("evidence", correlation.getEvidence());
		}

		return data;
	}
}