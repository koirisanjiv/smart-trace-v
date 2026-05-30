package com.qaverse.smart.trace.trace.investigation;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.trace.evidence.FailureEvidence;
import com.qaverse.smart.trace.trace.fingerprint.FailureFingerprint;
import com.qaverse.smart.trace.trace.rootcause.RootCauseTree;
import com.qaverse.smart.trace.trace.similarity.SimilarityResult;

public class InvestigationRecord {

	private FailureRecord failure;

	private FailureEvidence evidence;

	private FailureFingerprint fingerprint;

	private SimilarityResult similarity;

	private RootCauseTree rootCauseTree;

	private InvestigationSummary summary;

	public FailureRecord getFailure() {
		return failure;
	}

	public void setFailure(FailureRecord failure) {

		this.failure = failure;
	}

	public FailureEvidence getEvidence() {
		return evidence;
	}

	public void setEvidence(FailureEvidence evidence) {

		this.evidence = evidence;
	}

	public FailureFingerprint getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(FailureFingerprint fingerprint) {

		this.fingerprint = fingerprint;
	}

	public SimilarityResult getSimilarity() {
		return similarity;
	}

	public void setSimilarity(SimilarityResult similarity) {

		this.similarity = similarity;
	}

	public RootCauseTree getRootCauseTree() {
		return rootCauseTree;
	}

	public void setRootCauseTree(RootCauseTree rootCauseTree) {

		this.rootCauseTree = rootCauseTree;
	}

	public InvestigationSummary getSummary() {
		return summary;
	}

	public void setSummary(InvestigationSummary summary) {

		this.summary = summary;
	}

	public String getFailureId() {

		return failure == null ? null : failure.getFailureId();
	}
}