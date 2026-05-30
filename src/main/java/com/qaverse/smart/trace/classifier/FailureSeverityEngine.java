package com.qaverse.smart.trace.classifier;

public class FailureSeverityEngine {

	public String getSeverity(String category) {

		if (category == null) {
			return "UNKNOWN";
		}

		switch (category) {

		case "NETWORK_FAILURE":
			return "BLOCKER";

		case "TIMING_FAILURE":
			return "CRITICAL";

		case "LOCATOR_FAILURE":
			return "MAJOR";

		case "ASSERTION_FAILURE":
			return "NORMAL";

		default:
			return "MINOR";
		}
	}
}