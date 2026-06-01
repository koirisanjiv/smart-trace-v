package com.qaverse.smart.trace.trace.fingerprint;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureFingerprintEngine {

	public FailureFingerprint create(FailureRecord record) {

		FailureFingerprint fingerprint = new FailureFingerprint();

		String signature = generateSignature(record);

		fingerprint.setSignature(signature);

		fingerprint.setFingerprintId(signature);

		fingerprint.setExceptionType(record.getExceptionType());

		if (record.getRootCause() != null) {

			fingerprint.setRootCause(record.getRootCause().getRootCause());
		}

		fingerprint.increment();

		return fingerprint;
	}

	private String generateSignature(FailureRecord record) {

		try {

			String rootCause = record.getRootCause() == null ? "UNKNOWN" : record.getRootCause().getRootCause();

			String source = record.getExceptionType() + "|" + rootCause + "|" + record.getTestName();

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

		String rootCause = record.getRootCause() == null ? "UNKNOWN" : record.getRootCause().getRootCause();

		return (record.getExceptionType() + rootCause + record.getTestName()).hashCode();
	}
}