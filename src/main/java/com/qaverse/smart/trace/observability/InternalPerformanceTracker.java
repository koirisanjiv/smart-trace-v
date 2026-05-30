package com.qaverse.smart.trace.observability;

public class InternalPerformanceTracker {

	private long startTime;

	public void startTracking() {

		startTime = System.currentTimeMillis();
	}

	public long stopTracking() {

		return System.currentTimeMillis() - startTime;
	}

	public void log(String operation, long duration) {

		System.out.println("[SMART-TRACE-INTERNAL] " + operation + " completed in " + duration + " ms");
	}
}