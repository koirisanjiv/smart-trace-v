package com.qaverse.smart.trace.model.failure;

import java.util.ArrayList;
import java.util.List;

public class CorrelationRecord {

	private int confidence;

	private final List<String> evidence = new ArrayList<>();

	public int getConfidence() {
		return confidence;
	}

	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}

	public List<String> getEvidence() {
		return evidence;
	}

	public void addEvidence(String value) {
		evidence.add(value);
	}
}