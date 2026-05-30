package com.qaverse.smart.trace.knowledge;

public class FlakyPatternRegistry {

	public boolean isFlaky(int retries, int failures, int executions) {

		if (executions == 0) {
			return false;
		}

		double failureRate = (double) failures / executions;

		return retries > 2 && failureRate > 0.30;
	}
}