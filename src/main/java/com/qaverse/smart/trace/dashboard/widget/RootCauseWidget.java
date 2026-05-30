package com.qaverse.smart.trace.dashboard.widget;

import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.model.failure.RootCauseRecord;

public class RootCauseWidget {

	public WidgetData build(FailureRecord record) {

		WidgetData data = new WidgetData();

		data.setWidgetId("root-cause-widget");

		data.setTitle("Root Cause Analysis");

		data.setType("ROOT_CAUSE");

		RootCauseRecord rootCause = record.getRootCause();

		if (rootCause != null) {

			data.put("rootCause", rootCause.getRootCause());

			data.put("category", rootCause.getCategory());

			data.put("severity", rootCause.getSeverity());

			data.put("priority", rootCause.getPriority());

			data.put("confidence", rootCause.getConfidence());
		}

		return data;
	}
}