package com.qaverse.smart.trace.recommendation;

public class EnvironmentRecommendationEngine {

	public String recommend(double cpuUsage, double memoryUsage) {

		if (cpuUsage > 90) {

			return "High CPU usage detected";
		}

		if (memoryUsage > 90) {

			return "High memory consumption detected";
		}

		if (cpuUsage > 70 && memoryUsage > 70) {

			return "Environment instability risk";
		}

		return "Environment looks stable";
	}
}