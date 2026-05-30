package com.qaverse.smart.trace.model.trace;

import java.time.LocalDateTime;
import java.util.UUID;

public class TraceSession {

	private final String sessionId;

	private final LocalDateTime startTime;

	private LocalDateTime endTime;

	private String status;

	public TraceSession() {

		this.sessionId = UUID.randomUUID().toString();

		this.startTime = LocalDateTime.now();

		this.status = "RUNNING";
	}

	public String getSessionId() {
		return sessionId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void finish(String status) {

		this.endTime = LocalDateTime.now();

		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}