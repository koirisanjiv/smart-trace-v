package com.qaverse.smart.trace.classifier;

public class FailureClassificationResult {

	private final String category;

	private final String priority;

	private final String severity;

	public FailureClassificationResult(String category, String priority, String severity) {

		this.category = category;
		this.priority = priority;
		this.severity = severity;
	}

	public String getCategory() {
		return category;
	}

	public String getPriority() {
		return priority;
	}

	public String getSeverity() {
		return severity;
	}

	@Override
	public String toString() {

		return "FailureClassificationResult{" + "category='" + category + '\'' + ", priority='" + priority + '\''
				+ ", severity='" + severity + '\'' + '}';
	}
}