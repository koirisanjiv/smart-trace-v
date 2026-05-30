package com.qaverse.smart.trace.trace.similarity;

public class SimilarFailure {

	private String failureId;

	private String testName;

	private String rootCause;

	private int similarityScore;

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

	public int getSimilarityScore() {
		return similarityScore;
	}

	public void setSimilarityScore(int similarityScore) {

		this.similarityScore = similarityScore;
	}
}