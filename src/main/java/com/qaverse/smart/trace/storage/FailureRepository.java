package com.qaverse.smart.trace.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureRepository {

	private final Map<String, FailureRecord> failures = new ConcurrentHashMap<>();

	public void save(FailureRecord record) {

		if (record == null) {
			return;
		}

		failures.put(record.getFailureId(), record);
	}

	public FailureRecord find(String failureId) {

		return failures.get(failureId);
	}

	public List<FailureRecord> findAll() {

		return new ArrayList<>(failures.values());
	}

	public boolean exists(String failureId) {

		return failures.containsKey(failureId);
	}

	public void delete(String failureId) {

		failures.remove(failureId);
	}

	public int size() {

		return failures.size();
	}
}