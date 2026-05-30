package com.qaverse.smart.trace.dashboard.widget;

import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.FailureRecord;

public class RecommendationWidget {

	public WidgetData build(FailureRecord record) {

		WidgetData data = new WidgetData();

		data.setWidgetId("recommendation-widget");

		data.setTitle("Recommendations");

		data.setType("RECOMMENDATION");

		data.put("recommendations", record.getRecommendations());

		return data;
	}
}