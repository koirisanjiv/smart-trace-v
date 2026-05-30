package com.qaverse.smart.trace.security;

public class TraceSecurityManager {

	private final SecretSanitizer secretSanitizer = new SecretSanitizer();

	private final PiiProtectionService piiProtectionService = new PiiProtectionService();

	public String secure(String key, String value) {

		String sanitized = secretSanitizer.sanitize(key, value);

		return piiProtectionService.sanitize(sanitized);
	}
}