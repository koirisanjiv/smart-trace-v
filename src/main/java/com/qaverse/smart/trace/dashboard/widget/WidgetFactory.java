package com.qaverse.smart.trace.dashboard.widget;

import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class WidgetFactory {

	public DashboardWidget create(String id, String title, WidgetData data) {

		return new DashboardWidget() {

			@Override
			public String getId() {
				return id;
			}

			@Override
			public String getTitle() {
				return title;
			}

			@Override
			public WidgetData getData() {
				return data;
			}

			@Override
			public boolean isVisible() {
				return true;
			}
		};
	}
}