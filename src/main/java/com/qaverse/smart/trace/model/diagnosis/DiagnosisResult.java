package com.qaverse.smart.trace.model.diagnosis;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class DiagnosisResult {

	private FailureRecord failureRecord;

	public FailureRecord getFailureRecord() {
		return failureRecord;
	}

	public void setFailureRecord(FailureRecord failureRecord) {

		this.failureRecord = failureRecord;
	}

	@Override
	public String toString() {

		return "DiagnosisResult{" + "failureRecord=" + failureRecord + '}';
	}
}