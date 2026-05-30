package com.qaverse.smart.trace.dashboard;

import java.util.Map;

public class SmartTraceDashboard {

	private final DashboardAggregator aggregator = new DashboardAggregator();

	public Map<String, Object> build() {

		return aggregator.aggregate();
	}

	public void printSummary() {

		Map<String, Object> dashboard = build();

		System.out.println("========== SMART TRACE ==========");

		System.out.println(dashboard);
	}

	public static void initialize() {

		System.out.println("[SMART-TRACE] Dashboard Initialized");
	}
}