package com.qaverse.smart.trace.trace.fingerprint;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FingerprintRepository {

	private final Map<String, FailureFingerprint> fingerprints = new ConcurrentHashMap<>();

	public void save(FailureFingerprint fingerprint) {

		fingerprints.put(fingerprint.getSignature(), fingerprint);

		System.out.println("[SMART-TRACE] Fingerprint Repository Size : " + fingerprints.size());
	}

	public FailureFingerprint find(String signature) {

		return fingerprints.get(signature);
	}

	public Collection<FailureFingerprint> findAll() {

		return fingerprints.values();
	}
}