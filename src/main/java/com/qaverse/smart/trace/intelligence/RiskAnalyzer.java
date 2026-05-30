package com.qaverse.smart.trace.intelligence;

public class RiskAnalyzer {

	public String analyze(int flakyCount, int environmentFailures) {

		if (flakyCount > 10 || environmentFailures > 5) {

			return "HIGH_RISK";
		}

		if (flakyCount > 5) {

			return "MEDIUM_RISK";
		}

		return "LOW_RISK";
	}
}