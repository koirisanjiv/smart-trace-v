package com.qaverse.smart.trace.dashboard.widget;

import java.util.ArrayList;
import java.util.List;

import com.qaverse.smart.trace.model.dashboard.WidgetData;
import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureDashboardBuilder {

	private final RootCauseWidget rootCauseWidget = new RootCauseWidget();

	private final FailureSummaryWidget summaryWidget = new FailureSummaryWidget();

	private final RecommendationWidget recommendationWidget = new RecommendationWidget();

	private final CorrelationWidget correlationWidget = new CorrelationWidget();

	public List<WidgetData> build(FailureRecord record) {

		List<WidgetData> widgets = new ArrayList<>();

		widgets.add(summaryWidget.build(record));

		widgets.add(rootCauseWidget.build(record));

		widgets.add(correlationWidget.build(record));

		widgets.add(recommendationWidget.build(record));

		return widgets;
	}
}