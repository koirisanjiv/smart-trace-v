package com.qaverse.smart.trace.analytics.widget;

import com.qaverse.smart.trace.analytics.AnalyticsResult;
import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class FailureHeatmapWidget {

	public WidgetData build(AnalyticsResult analytics) {

		WidgetData data = new WidgetData();

		data.setWidgetId("failure-heatmap-widget");

		data.setTitle("Failure Heatmap");

		data.setType("HEATMAP");

		data.put("patterns", analytics.getPatterns());

		return data;
	}
}