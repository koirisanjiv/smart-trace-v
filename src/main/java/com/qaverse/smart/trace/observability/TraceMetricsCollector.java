package com.qaverse.smart.trace.observability;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TraceMetricsCollector {

	private final Map<String, Long> metrics = new ConcurrentHashMap<>();

	public void increment(String key) {

		metrics.merge(key, 1L, Long::sum);
	}

	public void set(String key, long value) {

		metrics.put(key, value);
	}

	public long get(String key) {

		return metrics.getOrDefault(key, 0L);
	}

	public Map<String, Long> getAll() {

		return metrics;
	}

	public void clear() {

		metrics.clear();
	}
}