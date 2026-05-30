package com.qaverse.smart.trace.analytics.widget;

import com.qaverse.smart.trace.analytics.AnalyticsResult;
import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class FlakyTestWidget {

	public WidgetData build(AnalyticsResult analytics) {

		WidgetData data = new WidgetData();

		data.setWidgetId("flaky-test-widget");

		data.setTitle("Flaky Tests");

		data.setType("FLAKY_TESTS");

		data.put("flakyTests", analytics.getFlakyTests());

		return data;
	}
}