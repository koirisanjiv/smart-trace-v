package com.qaverse.smart.trace.recommendation;

public class FlakyTestRecommendationEngine {

	public String analyze(int retries, int failures) {

		if (retries > 3 && failures > 3) {

			return "Highly flaky test detected";
		}

		if (retries > 1) {

			return "Moderate flaky behavior detected";
		}

		return "Stable execution pattern";
	}
}