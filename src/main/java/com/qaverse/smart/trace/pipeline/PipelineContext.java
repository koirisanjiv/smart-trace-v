package com.qaverse.smart.trace.pipeline;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PipelineContext {

	private final Map<String, Object> data = new ConcurrentHashMap<>();

	public void put(String key, Object value) {

		data.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String key) {

		return (T) data.get(key);
	}

	public boolean contains(String key) {

		return data.containsKey(key);
	}

	public void clear() {

		data.clear();
	}
}