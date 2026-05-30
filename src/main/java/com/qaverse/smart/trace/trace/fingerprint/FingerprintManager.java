package com.qaverse.smart.trace.trace.fingerprint;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FingerprintManager {

	private final FingerprintRepository repository = new FingerprintRepository();

	private final FailureFingerprintEngine engine = new FailureFingerprintEngine();

	public FailureFingerprint process(FailureRecord record) {

		FailureFingerprint fingerprint = engine.create(record);

		FailureFingerprint existing = repository.find(fingerprint.getSignature());

		if (existing != null) {

			existing.increment();

			return existing;
		}

		repository.save(fingerprint);

		return fingerprint;
	}
}