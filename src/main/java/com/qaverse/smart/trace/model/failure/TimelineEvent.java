package com.qaverse.smart.trace.model.failure;

import java.time.LocalDateTime;

import com.qaverse.smart.trace.trace.timeline.TimelineEventType;

public class TimelineEvent {

	private TimelineEventType type;

	private String message;

	private LocalDateTime timestamp;

	public TimelineEvent() {

		this.timestamp = LocalDateTime.now();
	}

	public TimelineEventType getType() {
		return type;
	}

	public void setType(TimelineEventType type) {

		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}