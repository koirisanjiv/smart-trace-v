package com.qaverse.smart.trace.intelligence;

import com.qaverse.smart.trace.analyzer.RootCauseAnalyzer;

public class RootCausePredictionEngine {

	private final RootCauseAnalyzer analyzer = new RootCauseAnalyzer();

	public String predict(Throwable throwable) {

		if (throwable == null) {
			return "Unknown root cause";
		}

		return analyzer.analyze(throwable);
	}
}