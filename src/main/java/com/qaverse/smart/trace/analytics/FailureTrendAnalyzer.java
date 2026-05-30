package com.qaverse.smart.trace.analytics;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureTrendAnalyzer {

	public Map<LocalDate, Integer> analyze(List<FailureRecord> failures) {

		Map<LocalDate, Integer> trends = new HashMap<>();

		for (FailureRecord failure : failures) {

			LocalDate date = failure.getFailureTime().toLocalDate();

			trends.merge(date, 1, Integer::sum);
		}

		return trends;
	}
}