package com.qaverse.smart.trace.classifier;

public class FailureClassifier {

	private final FailureCategoryEngine categoryEngine = new FailureCategoryEngine();

	private final FailurePriorityEngine priorityEngine = new FailurePriorityEngine();

	private final FailureSeverityEngine severityEngine = new FailureSeverityEngine();

	public FailureClassificationResult classify(Throwable throwable) {

		String category = categoryEngine.categorize(throwable);

		String priority = priorityEngine.getPriority(category);

		String severity = severityEngine.getSeverity(category);

		return new FailureClassificationResult(category, priority, severity);
	}
}