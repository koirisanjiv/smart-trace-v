package com.qaverse.smart.trace.correlation;

import java.util.ArrayList;
import java.util.List;

public class CorrelationResult {

	private final List<String> evidence = new ArrayList<>();

	private String rootCause;

	private int confidence;

	public void addEvidence(String value) {
		evidence.add(value);
	}

	public List<String> getEvidence() {
		return evidence;
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

	@Override
	public String toString() {

		return "CorrelationResult{" + "evidence=" + evidence + ", rootCause='" + rootCause + '\'' + ", confidence="
				+ confidence + '}';
	}
}