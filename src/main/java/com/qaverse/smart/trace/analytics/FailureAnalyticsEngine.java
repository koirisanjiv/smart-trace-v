package com.qaverse.smart.trace.analytics;

import java.util.List;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureAnalyticsEngine {

	private final FailureFrequencyAnalyzer frequencyAnalyzer = new FailureFrequencyAnalyzer();

	private final FailurePatternAnalyzer patternAnalyzer = new FailurePatternAnalyzer();

	private final FailureTrendAnalyzer trendAnalyzer = new FailureTrendAnalyzer();

	private final FlakyTestAnalyzer flakyTestAnalyzer = new FlakyTestAnalyzer();

	public AnalyticsResult analyze(List<FailureRecord> failures) {

		AnalyticsResult result = new AnalyticsResult();

		result.setFrequency(frequencyAnalyzer.analyze(failures));

		result.setPatterns(patternAnalyzer.analyze(failures));

		result.setFlakyTests(flakyTestAnalyzer.analyze(failures));

		result.setTrends(trendAnalyzer.analyze(failures));

		return result;
	}
}