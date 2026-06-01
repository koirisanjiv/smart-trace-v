package com.qaverse.smart.trace.trace.investigation;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureInvestigationEngine {

	public InvestigationSummary summarize(FailureRecord record) {

		InvestigationSummary summary = new InvestigationSummary();

		summary.setRootCause("UNKNOWN");
		summary.setConfidence(0);
		summary.setSeverity("UNCLASSIFIED");
		summary.setPriority("MEDIUM");

		if (record.getRootCause() != null) {

			summary.setRootCause(record.getRootCause().getRootCause());

			summary.setConfidence(record.getRootCause().getConfidence());

			summary.setSeverity(record.getRootCause().getSeverity());

			summary.setPriority(record.getRootCause().getPriority());
		}

		if (!record.getRecommendations().isEmpty()) {

			summary.setRecommendedAction(record.getRecommendations().get(0));
		}

		return summary;
	}
}