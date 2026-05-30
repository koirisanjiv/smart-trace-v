package com.qaverse.smart.trace.api;

import java.util.HashMap;
import java.util.Map;

import com.qaverse.smart.trace.observability.HealthMetrics;

public class HealthController {

	public Map<String, Object> health() {

		HealthMetrics metrics = new HealthMetrics();

		metrics.setCpuUsage(0);
		metrics.setMemoryUsage(0);
		metrics.setActiveThreads(Thread.activeCount());

		Map<String, Object> response = new HashMap<>();

		response.put("status", "UP");

		response.put("healthMetrics", metrics);

		return response;
	}
}