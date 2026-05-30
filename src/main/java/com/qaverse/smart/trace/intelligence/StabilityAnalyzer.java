package com.qaverse.smart.trace.intelligence;

public class StabilityAnalyzer {

	public double analyze(int passed, int failed) {

		int total = passed + failed;

		if (total == 0) {
			return 0;
		}

		return ((double) passed / total) * 100;
	}
}