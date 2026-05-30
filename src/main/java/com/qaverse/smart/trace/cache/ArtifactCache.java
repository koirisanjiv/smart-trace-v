package com.qaverse.smart.trace.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ArtifactCache {

	private final Map<String, Object> cache = new ConcurrentHashMap<>();

	public void put(String key, Object value) {

		cache.put(key, value);
	}

	public Object get(String key) {

		return cache.get(key);
	}

	public boolean contains(String key) {

		return cache.containsKey(key);
	}

	public void remove(String key) {

		cache.remove(key);
	}

	public void clear() {

		cache.clear();
	}
}