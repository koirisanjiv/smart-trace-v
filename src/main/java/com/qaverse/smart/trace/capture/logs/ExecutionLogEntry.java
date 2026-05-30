package com.qaverse.smart.trace.capture.logs;

import java.time.LocalDateTime;

public class ExecutionLogEntry {

	private final String message;

	private final LocalDateTime timestamp = LocalDateTime.now();

	public ExecutionLogEntry(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}