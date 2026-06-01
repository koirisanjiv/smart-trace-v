package com.qaverse.smart.trace.dashboard.html;

public class SmartTraceDashboardMetrics {

	private int totalFailures;

	private int criticalFailures;

	private int uniqueFingerprints;

	private int recurringFailures;

	public int getTotalFailures() {
		return totalFailures;
	}

	public void setTotalFailures(int totalFailures) {
		this.totalFailures = totalFailures;
	}

	public int getCriticalFailures() {
		return criticalFailures;
	}

	public void setCriticalFailures(int criticalFailures) {
		this.criticalFailures = criticalFailures;
	}

	public int getUniqueFingerprints() {
		return uniqueFingerprints;
	}

	public void setUniqueFingerprints(int uniqueFingerprints) {
		this.uniqueFingerprints = uniqueFingerprints;
	}

	public int getRecurringFailures() {
		return recurringFailures;
	}

	public void setRecurringFailures(int recurringFailures) {
		this.recurringFailures = recurringFailures;
	}
}