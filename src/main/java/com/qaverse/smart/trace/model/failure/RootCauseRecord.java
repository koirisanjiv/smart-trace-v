package com.qaverse.smart.trace.model.failure;

public class RootCauseRecord {

	private String rootCause;

	private String category;

	private String severity;

	private String priority;

	private int confidence;

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {

		this.rootCause = rootCause;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {

		this.category = category;
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

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {

		this.confidence = confidence;
	}
}