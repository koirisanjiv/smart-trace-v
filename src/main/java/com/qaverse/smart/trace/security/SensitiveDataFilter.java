package com.qaverse.smart.trace.security;

import java.util.Arrays;
import java.util.List;

public class SensitiveDataFilter {

	private static final List<String> SENSITIVE_KEYS = Arrays.asList("password", "token", "secret", "apikey",
			"authorization", "bearer");

	public boolean isSensitive(String key) {

		if (key == null) {
			return false;
		}

		String lower = key.toLowerCase();

		return SENSITIVE_KEYS.stream().anyMatch(lower::contains);
	}
}