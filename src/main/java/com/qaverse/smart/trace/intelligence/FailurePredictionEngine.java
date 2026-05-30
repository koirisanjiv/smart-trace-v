package com.qaverse.smart.trace.intelligence;

public class FailurePredictionEngine {

	public String predict(int previousFailures, int retryCount) {

		if (previousFailures > 5 && retryCount > 2) {

			return "HIGH_FAILURE_RISK";
		}

		if (previousFailures > 2) {

			return "MEDIUM_FAILURE_RISK";
		}

		return "LOW_FAILURE_RISK";
	}
}