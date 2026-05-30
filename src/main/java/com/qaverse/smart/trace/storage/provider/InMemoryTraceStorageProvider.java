package com.qaverse.smart.trace.storage.provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTraceStorageProvider implements TraceStorageProvider {

	private final Map<String, Object> storage = new ConcurrentHashMap<>();

	@Override
	public void save(String key, Object value) {

		storage.put(key, value);
	}

	@Override
	public Object get(String key) {

		return storage.get(key);
	}

	@Override
	public boolean exists(String key) {

		return storage.containsKey(key);
	}

	@Override
	public void delete(String key) {

		storage.remove(key);
	}
}