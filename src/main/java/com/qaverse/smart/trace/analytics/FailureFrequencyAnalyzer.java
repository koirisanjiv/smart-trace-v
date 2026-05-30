package com.qaverse.smart.trace.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureFrequencyAnalyzer {

	public Map<String, Integer> analyze(List<FailureRecord> failures) {

		Map<String, Integer> frequency = new HashMap<>();

		for (FailureRecord failure : failures) {

			String exceptionType = failure.getExceptionType();

			frequency.merge(exceptionType, 1, Integer::sum);
		}

		return frequency;
	}
}