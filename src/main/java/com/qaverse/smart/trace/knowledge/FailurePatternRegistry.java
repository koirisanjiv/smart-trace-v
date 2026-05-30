package com.qaverse.smart.trace.knowledge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailurePatternRegistry {

	private final Map<String, String> patterns = new ConcurrentHashMap<>();

	public FailurePatternRegistry() {

		registerDefaults();
	}

	private void registerDefaults() {

		patterns.put("timeout", "Application synchronization issue");

		patterns.put("stale", "DOM refresh issue");

		patterns.put("nosuchelement", "Locator strategy issue");

		patterns.put("connection", "Environment instability");
	}

	public void register(String pattern, String reason) {

		patterns.put(pattern, reason);
	}

	public String identify(String failureMessage) {

		if (failureMessage == null) {
			return "Unknown failure pattern";
		}

		String message = failureMessage.toLowerCase();

		for (Map.Entry<String, String> entry : patterns.entrySet()) {

			if (message.contains(entry.getKey())) {

				return entry.getValue();
			}
		}

		return "No matching pattern found";
	}
}