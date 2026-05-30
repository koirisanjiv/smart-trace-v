package com.qaverse.smart.trace.performance;

public class TracePerformanceMonitor {

	private long startTime;

	public void start() {

		startTime = System.currentTimeMillis();
	}

	public long stop() {

		return System.currentTimeMillis() - startTime;
	}

	public void logExecutionTime(String operation, long duration) {

		System.out.println("[SMART-TRACE-PERFORMANCE] " + operation + " executed in " + duration + " ms");
	}
}