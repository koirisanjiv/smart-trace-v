package com.qaverse.smart.trace.capture.logs;

import java.util.ArrayList;
import java.util.List;

public class ExecutionLogRepository {

	private final List<ExecutionLogEntry> entries = new ArrayList<>();

	public void add(String message) {

		entries.add(new ExecutionLogEntry(message));
	}

	public List<ExecutionLogEntry> getAll() {

		return new ArrayList<>(entries);
	}

	public void clear() {

		entries.clear();
	}
}