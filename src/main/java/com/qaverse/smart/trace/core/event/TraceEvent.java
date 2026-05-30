package com.qaverse.smart.trace.core.event;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TraceEvent {

	private final String eventId;

	private final TraceEventType type;

	private final LocalDateTime timestamp;

	private final Map<String, Object> payload = new HashMap<>();

	public TraceEvent(TraceEventType type) {

		this.eventId = UUID.randomUUID().toString();

		this.type = type;

		this.timestamp = LocalDateTime.now();
	}

	public String getEventId() {
		return eventId;
	}

	public TraceEventType getType() {
		return type;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Map<String, Object> getPayload() {
		return payload;
	}

	public TraceEvent add(String key, Object value) {

		payload.put(key, value);

		return this;
	}
}