package com.qaverse.smart.trace.dashboard.widget;

import com.qaverse.smart.trace.model.dashboard.WidgetData;

public interface DashboardWidget {

	String getId();

	String getTitle();

	WidgetData getData();

	boolean isVisible();
}