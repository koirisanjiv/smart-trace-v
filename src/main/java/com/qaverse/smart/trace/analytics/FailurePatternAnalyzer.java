package com.qaverse.smart.trace.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailurePatternAnalyzer {

	public Map<String, Integer> analyze(List<FailureRecord> failures) {

		Map<String, Integer> patterns = new HashMap<>();

		for (FailureRecord failure : failures) {

			if (failure.getRootCause() == null) {
				continue;
			}

			String category = failure.getRootCause().getCategory();

			patterns.merge(category, 1, Integer::sum);
		}

		return patterns;
	}
}