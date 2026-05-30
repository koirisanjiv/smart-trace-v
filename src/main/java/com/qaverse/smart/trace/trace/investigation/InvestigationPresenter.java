package com.qaverse.smart.trace.trace.investigation;

public class InvestigationPresenter {

	public String present(InvestigationRecord record) {

		InvestigationSummary summary = record.getSummary();

		StringBuilder builder = new StringBuilder();

		builder.append("\n");
		builder.append("===== SMART TRACE =====\n");

		builder.append("Root Cause : ").append(summary.getRootCause()).append("\n");

		builder.append("Confidence : ").append(summary.getConfidence()).append("%\n");

		builder.append("Severity : ").append(summary.getSeverity()).append("\n");

		builder.append("Priority : ").append(summary.getPriority()).append("\n");

		builder.append("Recommended Action : ").append(summary.getRecommendedAction()).append("\n");

		builder.append("=======================\n");

		return builder.toString();
	}
}