package com.qaverse.smart.trace.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CorrelationCache {

	private final Map<String, Object> correlations = new ConcurrentHashMap<>();

	public void put(String key, Object value) {

		correlations.put(key, value);
	}

	public Object get(String key) {

		return correlations.get(key);
	}

	public boolean contains(String key) {

		return correlations.containsKey(key);
	}

	public void clear() {

		correlations.clear();
	}
}