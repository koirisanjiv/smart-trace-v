package com.qaverse.smart.trace.dashboard.widget;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WidgetRegistry {

	private final Map<String, DashboardWidget> widgets = new ConcurrentHashMap<>();

	public void register(DashboardWidget widget) {

		widgets.put(widget.getId(), widget);
	}

	public DashboardWidget get(String widgetId) {

		return widgets.get(widgetId);
	}

	public Collection<DashboardWidget> getAll() {

		return widgets.values();
	}

	public boolean contains(String widgetId) {

		return widgets.containsKey(widgetId);
	}
}