package com.qaverse.smart.trace.classifier;

public class FailureCategoryEngine {

	public String categorize(Throwable throwable) {

		if (throwable == null) {
			return "UNKNOWN_FAILURE";
		}

		String name = throwable.getClass().getSimpleName().toLowerCase();

		if (name.contains("timeout")) {
			return "TIMING_FAILURE";
		}

		if (name.contains("nosuchelement")) {
			return "LOCATOR_FAILURE";
		}

		if (name.contains("stale")) {
			return "DOM_FAILURE";
		}

		if (name.contains("assert")) {
			return "ASSERTION_FAILURE";
		}

		if (name.contains("connection")) {
			return "NETWORK_FAILURE";
		}

		return "UNKNOWN_FAILURE";
	}
}