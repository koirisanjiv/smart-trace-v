package com.qaverse.smart.trace.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FlakyTestAnalyzer {

	public Map<String, Integer> analyze(List<FailureRecord> failures) {

		Map<String, Integer> flakyTests = new HashMap<>();

		for (FailureRecord failure : failures) {

			flakyTests.merge(failure.getTestName(), 1, Integer::sum);
		}

		return flakyTests;
	}
}