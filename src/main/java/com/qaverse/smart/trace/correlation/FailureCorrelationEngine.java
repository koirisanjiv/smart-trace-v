package com.qaverse.smart.trace.correlation;

import com.qaverse.smart.trace.classifier.ConfidenceScoreEngine;

public class FailureCorrelationEngine {

	private final MultiSourceCorrelationEngine multiSourceCorrelationEngine = new MultiSourceCorrelationEngine();

	private final ConfidenceScoreEngine confidenceScoreEngine = new ConfidenceScoreEngine();

	public CorrelationResult analyze(Throwable throwable, String logs, long apiTime, boolean domUpdated) {

		CorrelationResult result = multiSourceCorrelationEngine.correlate(throwable, logs, apiTime, domUpdated);

		int confidence = confidenceScoreEngine.calculate(result.getRootCause(), throwable);

		result.setConfidence(confidence);

		return result;
	}
}