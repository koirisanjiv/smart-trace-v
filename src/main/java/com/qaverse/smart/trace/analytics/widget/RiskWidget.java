package com.qaverse.smart.trace.analytics.widget;

import java.util.Map;

import com.qaverse.smart.trace.analytics.AnalyticsResult;
import com.qaverse.smart.trace.model.dashboard.WidgetData;

public class RiskWidget {

	public WidgetData build(AnalyticsResult analytics) {

		WidgetData data = new WidgetData();

		data.setWidgetId("risk-widget");

		data.setTitle("Risk Analysis");

		data.setType("RISK");

		int riskScore = calculateRisk(analytics.getFlakyTests());

		data.put("riskScore", riskScore);

		data.put("riskLevel", getRiskLevel(riskScore));

		return data;
	}

	private int calculateRisk(Map<String, Integer> flakyTests) {

		int score = 0;

		for (Integer count : flakyTests.values()) {

			score += count;
		}

		return score;
	}

	private String getRiskLevel(int score) {

		if (score >= 50) {
			return "HIGH";
		}

		if (score >= 20) {
			return "MEDIUM";
		}

		return "LOW";
	}
}