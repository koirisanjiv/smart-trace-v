package com.qaverse.smart.trace.security;

import java.util.regex.Pattern;

public class PiiProtectionService {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+");

	public String sanitize(String text) {

		if (text == null) {
			return null;
		}

		return EMAIL_PATTERN.matcher(text).replaceAll("***@***.***");
	}
}