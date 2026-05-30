package com.qaverse.smart.trace.recommendation;

public class WaitStrategyRecommendationEngine {

	public String recommend(Throwable throwable) {

		if (throwable == null || throwable.getMessage() == null) {

			return "Default wait strategy";
		}

		String message = throwable.getMessage().toLowerCase();

		if (message.contains("click")) {

			return "Wait until element clickable";
		}

		if (message.contains("visible")) {

			return "Wait until visibility located";
		}

		if (message.contains("stale")) {

			return "Wait for DOM refresh completion";
		}

		return "Use explicit wait strategy";
	}
}