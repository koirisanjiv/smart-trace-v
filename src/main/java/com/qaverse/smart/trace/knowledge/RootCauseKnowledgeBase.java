package com.qaverse.smart.trace.knowledge;

public class RootCauseKnowledgeBase {

	private final FailurePatternRegistry patternRegistry = new FailurePatternRegistry();

	private final KnownIssueRegistry knownIssueRegistry = new KnownIssueRegistry();

	public String search(Throwable throwable) {

		if (throwable == null) {
			return "No root cause available";
		}

		String message = throwable.getMessage();

		if (message == null) {
			return "Unknown root cause";
		}

		String knownPattern = patternRegistry.identify(message);

		if (!knownPattern.equals("No matching pattern found")) {

			return knownPattern;
		}

		if (knownIssueRegistry.exists(message)) {

			return knownIssueRegistry.get(message);
		}

		return "Knowledge base match not found";
	}
}