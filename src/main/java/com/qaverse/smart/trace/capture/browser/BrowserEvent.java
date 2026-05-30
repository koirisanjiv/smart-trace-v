package com.qaverse.smart.trace.capture.browser;

import java.time.LocalDateTime;

public class BrowserEvent {

	private String action;

	private LocalDateTime timestamp = LocalDateTime.now();

	public BrowserEvent(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}