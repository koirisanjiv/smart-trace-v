package com.qaverse.smart.trace.trace.fingerprint;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureFingerprintEngine {

	public FailureFingerprint create(FailureRecord record) {

		FailureFingerprint fingerprint = new FailureFingerprint();

		fingerprint.setFingerprintId(UUID.randomUUID().toString());

		fingerprint.setExceptionType(record.getExceptionType());

		if (record.getRootCause() != null) {

			fingerprint.setRootCause(record.getRootCause().getRootCause());
		}

		String signature = generateSignature(record);

		fingerprint.setSignature(signature);

		fingerprint.increment();

		return fingerprint;
	}

	private String generateSignature(FailureRecord record) {

		try {

			String source = record.getExceptionType() + "|" + record.getExceptionMessage();

			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(source.getBytes(StandardCharsets.UTF_8));

			StringBuilder builder = new StringBuilder();

			for (byte b : hash) {

				builder.append(String.format("%02x", b));
			}

			return builder.toString();

		} catch (Exception e) {

			return String.valueOf(sourceHash(record));
		}
	}

	private int sourceHash(FailureRecord record) {

		return (record.getExceptionType() + record.getExceptionMessage()).hashCode();
	}
}