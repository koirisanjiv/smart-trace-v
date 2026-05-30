package com.qaverse.smart.trace.api;

import java.util.Map;

import com.qaverse.smart.trace.dashboard.SmartTraceDashboard;

public class DashboardController {

	private final SmartTraceDashboard smartTraceDashboard = new SmartTraceDashboard();


	public Map<String, Object> dashboard() {

		return smartTraceDashboard.build();
	}
}