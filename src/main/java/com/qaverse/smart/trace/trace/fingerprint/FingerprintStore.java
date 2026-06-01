package com.qaverse.smart.trace.trace.fingerprint;

public final class FingerprintStore {

	private static final FingerprintRepository REPOSITORY = new FingerprintRepository();

	private FingerprintStore() {
	}

	public static FingerprintRepository getRepository() {

		return REPOSITORY;
	}
}