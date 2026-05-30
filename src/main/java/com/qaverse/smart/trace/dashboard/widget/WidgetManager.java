package com.qaverse.smart.trace.dashboard.widget;

import java.util.Collection;

import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class WidgetManager {

	private final WidgetRegistry registry = new WidgetRegistry();

	private final WidgetFactory factory = new WidgetFactory();

	public void addWidget(String id, String title, WidgetData data) {

		registry.register(factory.create(id, title, data));
	}

	public DashboardWidget getWidget(String id) {

		return registry.get(id);
	}

	public Collection<DashboardWidget> getWidgets() {

		return registry.getAll();
	}

	public int totalWidgets() {

		return registry.getAll().size();
	}
}