package com.qaverse.smart.trace.intelligence;

public class ImpactAnalyzer {

	public String analyze(String severity, int affectedTests) {

		if ("BLOCKER".equals(severity) && affectedTests > 10) {

			return "SYSTEM_WIDE_IMPACT";
		}

		if ("CRITICAL".equals(severity)) {

			return "HIGH_PROJECT_IMPACT";
		}

		return "LIMITED_IMPACT";
	}
}