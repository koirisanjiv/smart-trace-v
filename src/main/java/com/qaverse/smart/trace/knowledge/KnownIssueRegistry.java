package com.qaverse.smart.trace.knowledge;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KnownIssueRegistry {

	private final Map<String, String> issues = new ConcurrentHashMap<>();

	public void register(String issueKey, String issueDescription) {

		issues.put(issueKey, issueDescription);
	}

	public boolean exists(String issueKey) {

		return issues.containsKey(issueKey);
	}

	public String get(String issueKey) {

		return issues.get(issueKey);
	}
}