package com.qaverse.smart.trace.dashboard;

import java.util.HashMap;
import java.util.Map;

public class DashboardAggregator {

	private final InvestigationDataProvider dataProvider = new InvestigationDataProvider();

	public Map<String, Object> aggregate() {

		Map<String, Object> dashboard = new HashMap<>();

		dashboard.put("generatedAt", System.currentTimeMillis());

		dashboard.put("widgets", dataProvider.loadData());

		return dashboard;
	}
}