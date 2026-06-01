package com.qaverse.smart.trace.trace.fingerprint;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FingerprintManager {

	private final FingerprintRepository repository = FingerprintStore.getRepository();

	private final FailureFingerprintEngine engine = new FailureFingerprintEngine();

	public FailureFingerprint process(FailureRecord record) {

		FailureFingerprint fingerprint = engine.create(record);

		FailureFingerprint existing = repository.find(fingerprint.getSignature());

		if (existing != null) {

			existing.increment();

			System.out.println("[SMART-TRACE] Existing Fingerprint : " + existing.getFingerprintId() + " Count : "
					+ existing.getOccurrenceCount());

			return existing;
		}

		repository.save(fingerprint);

		System.out.println("[SMART-TRACE] New Fingerprint : " + fingerprint.getFingerprintId());

		return fingerprint;
	}
}