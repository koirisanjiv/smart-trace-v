package com.qaverse.smart.trace.analytics.widget;

import com.qaverse.smart.trace.analytics.AnalyticsResult;
import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class FailureTrendWidget {

	public WidgetData build(AnalyticsResult analytics) {

		WidgetData data = new WidgetData();

		data.setWidgetId("failure-trend-widget");

		data.setTitle("Failure Trends");

		data.setType("TREND");

		data.put("trends", analytics.getTrends());

		return data;
	}
}