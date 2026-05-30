package com.qaverse.smart.trace.performance;

public class MemoryOptimizer {

	public void optimize() {

		Runtime runtime = Runtime.getRuntime();

		long usedMemory = runtime.totalMemory() - runtime.freeMemory();

		long mb = usedMemory / (1024 * 1024);

		if (mb > 512) {

			System.gc();
		}
	}

	public long currentMemoryUsageMb() {

		Runtime runtime = Runtime.getRuntime();

		long usedMemory = runtime.totalMemory() - runtime.freeMemory();

		return usedMemory / (1024 * 1024);
	}
}