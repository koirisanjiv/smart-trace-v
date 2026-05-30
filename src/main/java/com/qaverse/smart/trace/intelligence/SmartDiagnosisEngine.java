package com.qaverse.smart.trace.intelligence;

import com.qaverse.smart.trace.classifier.FailureClassificationResult;
import com.qaverse.smart.trace.classifier.FailureClassifier;
import com.qaverse.smart.trace.correlation.CorrelationResult;
import com.qaverse.smart.trace.correlation.FailureCorrelationEngine;
import com.qaverse.smart.trace.model.diagnosis.DiagnosisResult;
import com.qaverse.smart.trace.model.failure.CorrelationRecord;
import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.model.failure.RootCauseRecord;
import com.qaverse.smart.trace.recommendation.FixRecommendationEngine;

public class SmartDiagnosisEngine {

	private final FailureClassifier failureClassifier = new FailureClassifier();

	private final RootCausePredictionEngine rootCausePredictionEngine = new RootCausePredictionEngine();

	private final FailureCorrelationEngine failureCorrelationEngine = new FailureCorrelationEngine();

	private final FixRecommendationEngine recommendationEngine = new FixRecommendationEngine();

	public DiagnosisResult diagnose(Throwable throwable, String logs, long apiTime, boolean domUpdated) {

		FailureClassificationResult classification = failureClassifier.classify(throwable);

		CorrelationResult correlation = failureCorrelationEngine.analyze(throwable, logs, apiTime, domUpdated);

		String rootCause = rootCausePredictionEngine.predict(throwable);

		FailureRecord failureRecord = new FailureRecord();

		RootCauseRecord rootCauseRecord = new RootCauseRecord();

		rootCauseRecord.setRootCause(rootCause);

		rootCauseRecord.setCategory(classification.getCategory());

		rootCauseRecord.setPriority(classification.getPriority());

		rootCauseRecord.setSeverity(classification.getSeverity());

		rootCauseRecord.setConfidence(correlation.getConfidence());

		failureRecord.setRootCause(rootCauseRecord);

		CorrelationRecord correlationRecord = new CorrelationRecord();

		correlationRecord.setConfidence(correlation.getConfidence());

		for (String evidence : correlation.getEvidence()) {

			correlationRecord.addEvidence(evidence);
		}

		failureRecord.setCorrelation(correlationRecord);

		if (throwable != null) {

			failureRecord.setExceptionType(throwable.getClass().getSimpleName());

			failureRecord.setExceptionMessage(throwable.getMessage());
		}

		failureRecord.addRecommendation(recommendationEngine.recommend(classification.getCategory()));

		DiagnosisResult result = new DiagnosisResult();

		result.setFailureRecord(failureRecord);

		failureRecord.setTestName("UNKNOWN_TEST");

		return result;
	}
}