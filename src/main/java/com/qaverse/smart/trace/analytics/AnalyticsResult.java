package com.qaverse.smart.trace.analytics;

import java.time.LocalDate;
import java.util.Map;

public class AnalyticsResult {

	private Map<String, Integer> frequency;

	private Map<String, Integer> patterns;

	private Map<String, Integer> flakyTests;

	private Map<LocalDate, Integer> trends;

	public Map<String, Integer> getFrequency() {
		return frequency;
	}

	public void setFrequency(Map<String, Integer> frequency) {
		this.frequency = frequency;
	}

	public Map<String, Integer> getPatterns() {
		return patterns;
	}

	public void setPatterns(Map<String, Integer> patterns) {
		this.patterns = patterns;
	}

	public Map<String, Integer> getFlakyTests() {
		return flakyTests;
	}

	public void setFlakyTests(Map<String, Integer> flakyTests) {
		this.flakyTests = flakyTests;
	}

	public Map<LocalDate, Integer> getTrends() {
		return trends;
	}

	public void setTrends(Map<LocalDate, Integer> trends) {
		this.trends = trends;
	}
}