package com.qaverse.smart.trace.security;

public class SecretSanitizer {

	private final DataMaskingEngine maskingEngine = new DataMaskingEngine();

	public String sanitize(String key, String value) {

		if (key == null) {
			return value;
		}

		String lower = key.toLowerCase();

		if (lower.contains("password") || lower.contains("token") || lower.contains("secret")
				|| lower.contains("apikey")) {

			return maskingEngine.mask(value);
		}

		return value;
	}
}