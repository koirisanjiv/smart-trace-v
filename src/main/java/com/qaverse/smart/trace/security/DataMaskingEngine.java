package com.qaverse.smart.trace.security;

public class DataMaskingEngine {

	public String mask(String value) {

		if (value == null || value.length() < 4) {

			return "****";
		}

		int visibleChars = 2;

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < value.length() - visibleChars; i++) {

			builder.append("*");
		}

		builder.append(value.substring(value.length() - visibleChars));

		return builder.toString();
	}
}