package com.qaverse.smart.trace.api.investigation;

import java.util.ArrayList;
import java.util.List;

public class InvestigationResponse {

	private String failureId;

	private String testName;

	private String rootCause;

	private int confidence;

	private String severity;

	private String priority;

	private String fingerprintId;

	private int similarFailures;

	private String recommendedAction;

	private final List<String> evidence = new ArrayList<>();

	public String getFailureId() {
		return failureId;
	}

	public void setFailureId(String failureId) {

		this.failureId = failureId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {

		this.testName = testName;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {

		this.rootCause = rootCause;
	}

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {

		this.confidence = confidence;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {

		this.severity = severity;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {

		this.priority = priority;
	}

	public String getFingerprintId() {
		return fingerprintId;
	}

	public void setFingerprintId(String fingerprintId) {

		this.fingerprintId = fingerprintId;
	}

	public int getSimilarFailures() {
		return similarFailures;
	}

	public void setSimilarFailures(int similarFailures) {

		this.similarFailures = similarFailures;
	}

	public String getRecommendedAction() {
		return recommendedAction;
	}

	public void setRecommendedAction(String recommendedAction) {

		this.recommendedAction = recommendedAction;
	}

	public List<String> getEvidence() {
		return evidence;
	}
}