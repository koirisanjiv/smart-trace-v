package com.qaverse.smart.trace.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExecutionCache {

	private final Map<String, Object> executions = new ConcurrentHashMap<>();

	public void put(String executionId, Object value) {

		executions.put(executionId, value);
	}

	public Object get(String executionId) {

		return executions.get(executionId);
	}

	public boolean contains(String executionId) {

		return executions.containsKey(executionId);
	}

	public void clear() {

		executions.clear();
	}
}