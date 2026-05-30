package com.qaverse.smart.trace.trace.fingerprint;

public class FailureFingerprint {

	private String fingerprintId;

	private String exceptionType;

	private String rootCause;

	private String locator;

	private String signature;

	private int occurrenceCount;

	public String getFingerprintId() {
		return fingerprintId;
	}

	public void setFingerprintId(String fingerprintId) {

		this.fingerprintId = fingerprintId;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {

		this.exceptionType = exceptionType;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {

		this.rootCause = rootCause;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {

		this.locator = locator;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {

		this.signature = signature;
	}

	public int getOccurrenceCount() {
		return occurrenceCount;
	}

	public void increment() {
		occurrenceCount++;
	}
}