package com.qaverse.smart.trace.recommendation;

public class RetryRecommendationEngine {

	public boolean shouldRetry(String category) {

		if (category == null) {
			return false;
		}

		switch (category) {

		case "TIMING_FAILURE":
		case "NETWORK_FAILURE":
		case "DOM_FAILURE":

			return true;

		default:

			return false;
		}
	}

	public int recommendedRetryCount(String category) {

		if (category == null) {
			return 0;
		}

		switch (category) {

		case "NETWORK_FAILURE":
			return 3;

		case "TIMING_FAILURE":
			return 2;

		case "DOM_FAILURE":
			return 2;

		default:
			return 0;
		}
	}
}