package com.qaverse.smart.trace.analyzer;

import java.util.LinkedHashMap;
import java.util.Map;

public class RootCauseAnalyzer {

	private static final Map<String, String> ROOT_CAUSE_PATTERNS = new LinkedHashMap<>();

	static {

		ROOT_CAUSE_PATTERNS.put("stale element reference", "DOM re-render caused stale element reference");

		ROOT_CAUSE_PATTERNS.put("timeout", "Application response delay detected");

		ROOT_CAUSE_PATTERNS.put("no such element", "Locator not found in current DOM");

		ROOT_CAUSE_PATTERNS.put("element click intercepted", "Element blocked by overlay or popup");

		ROOT_CAUSE_PATTERNS.put("connection refused", "Environment or service unavailable");

		ROOT_CAUSE_PATTERNS.put("assertion", "Business validation mismatch");
	}

	public String analyze(Throwable throwable) {

		if (throwable == null) {
			return "Unknown root cause";
		}

		String message = buildSearchableMessage(throwable);

		for (Map.Entry<String, String> entry : ROOT_CAUSE_PATTERNS.entrySet()) {

			if (message.contains(entry.getKey())) {
				return entry.getValue();
			}
		}

		return "Root cause pattern not identified";
	}

	private String buildSearchableMessage(Throwable throwable) {

		StringBuilder builder = new StringBuilder();

		if (throwable.getMessage() != null) {
			builder.append(throwable.getMessage().toLowerCase());
		}

		builder.append(" ");

		builder.append(throwable.getClass().getSimpleName().toLowerCase());

		return builder.toString();
	}
}