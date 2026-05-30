package com.qaverse.smart.trace.healing;

public class SmartRetryEngine {

	public boolean shouldRetry(Throwable throwable) {

		if (throwable == null) {
			return false;
		}

		String name = throwable.getClass().getSimpleName().toLowerCase();

		return name.contains("timeout") || name.contains("stale") || name.contains("connection");
	}

	public int maxRetryCount(Throwable throwable) {

		if (throwable == null) {
			return 0;
		}

		String name = throwable.getClass().getSimpleName().toLowerCase();

		if (name.contains("timeout")) {
			return 2;
		}

		if (name.contains("connection")) {
			return 3;
		}

		return 1;
	}
}