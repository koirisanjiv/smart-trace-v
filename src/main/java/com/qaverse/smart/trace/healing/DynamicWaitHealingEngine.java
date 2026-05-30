package com.qaverse.smart.trace.healing;

public class DynamicWaitHealingEngine {

	public long recommendWaitTime(Throwable throwable) {

		if (throwable == null || throwable.getMessage() == null) {

			return 2000;
		}

		String message = throwable.getMessage().toLowerCase();

		if (message.contains("timeout")) {

			return 10000;
		}

		if (message.contains("stale")) {

			return 3000;
		}

		if (message.contains("click")) {

			return 5000;
		}

		return 2000;
	}
}