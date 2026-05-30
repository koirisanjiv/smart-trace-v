package com.qaverse.smart.trace.model.dashboard;

import java.util.HashMap;
import java.util.Map;

public class WidgetData {

	private String widgetId;

	private String title;

	private String type;

	private final Map<String, Object> data = new HashMap<>();

	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {

		this.widgetId = widgetId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void put(String key, Object value) {

		data.put(key, value);
	}

	public Object get(String key) {

		return data.get(key);
	}

	@Override
	public String toString() {

		return "WidgetData{" + "widgetId='" + widgetId + '\'' + ", title='" + title + '\'' + ", type='" + type + '\''
				+ ", data=" + data + '}';
	}
}