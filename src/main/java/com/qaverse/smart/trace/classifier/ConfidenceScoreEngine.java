package com.qaverse.smart.trace.classifier;

public class ConfidenceScoreEngine {

	public int calculate(String rootCause, Throwable throwable) {

		int score = 50;

		if (rootCause == null || throwable == null) {
			return score;
		}

		String message = throwable.getMessage() == null ? "" : throwable.getMessage().toLowerCase();

		if (message.contains("timeout")) {
			score += 20;
		}

		if (message.contains("stale")) {
			score += 25;
		}

		if (message.contains("element")) {
			score += 10;
		}

		if (rootCause.toLowerCase().contains("dom")) {
			score += 10;
		}

		if (score > 99) {
			score = 99;
		}

		return score;
	}
}