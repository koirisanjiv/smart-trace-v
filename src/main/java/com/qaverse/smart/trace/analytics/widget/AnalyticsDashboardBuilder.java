package com.qaverse.smart.trace.analytics.widget;

import java.util.ArrayList;
import java.util.List;

import com.qaverse.smart.trace.analytics.AnalyticsResult;
import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class AnalyticsDashboardBuilder {

	private final FailureTrendWidget trendWidget = new FailureTrendWidget();

	private final FlakyTestWidget flakyWidget = new FlakyTestWidget();

	private final FailureHeatmapWidget heatmapWidget = new FailureHeatmapWidget();

	private final RiskWidget riskWidget = new RiskWidget();

	public List<WidgetData> build(AnalyticsResult analytics) {

		List<WidgetData> widgets = new ArrayList<>();

		widgets.add(trendWidget.build(analytics));

		widgets.add(flakyWidget.build(analytics));

		widgets.add(heatmapWidget.build(analytics));

		widgets.add(riskWidget.build(analytics));

		return widgets;
	}
}