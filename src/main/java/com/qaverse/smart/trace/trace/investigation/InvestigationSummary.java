package com.qaverse.smart.trace.trace.investigation;

public class InvestigationSummary {

	private String rootCause;

	private int confidence;

	private String severity;

	private String priority;

	private String recommendedAction;

	private String fingerprintId;

	private int similarFailures;

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

	public String getRecommendedAction() {
		return recommendedAction;
	}

	public void setRecommendedAction(String recommendedAction) {

		this.recommendedAction = recommendedAction;
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
}