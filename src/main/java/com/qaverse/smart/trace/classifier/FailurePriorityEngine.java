package com.qaverse.smart.trace.classifier;

public class FailurePriorityEngine {

	public String getPriority(String category) {

		if (category == null) {
			return "MEDIUM";
		}

		switch (category) {

		case "NETWORK_FAILURE":
			return "CRITICAL";

		case "TIMING_FAILURE":
			return "HIGH";

		case "LOCATOR_FAILURE":
			return "HIGH";

		case "ASSERTION_FAILURE":
			return "MEDIUM";

		default:
			return "LOW";
		}
	}
}