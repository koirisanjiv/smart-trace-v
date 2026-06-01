package com.qaverse.smart.trace.api.investigation;

import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;
import com.qaverse.smart.trace.trace.investigation.InvestigationSummary;

public class InvestigationMapper {

	public InvestigationResponse map(InvestigationRecord record) {

		InvestigationResponse response = new InvestigationResponse();

		if (record == null) {

			return response;
		}

		if (record.getFailure() != null) {

			response.setFailureId(record.getFailure().getFailureId());

			response.setTestName(record.getFailure().getTestName());
		}

		InvestigationSummary summary = record.getSummary();

		if (summary != null) {

			response.setRootCause(summary.getRootCause());

			response.setConfidence(summary.getConfidence());

			response.setSeverity(summary.getSeverity());

			response.setPriority(summary.getPriority());

			response.setFingerprintId(summary.getFingerprintId());

			response.setSimilarFailures(summary.getSimilarFailures());

			response.setRecommendedAction(summary.getRecommendedAction());
		}

		if (record.getEvidence() != null && record.getEvidence().getLogs() != null) {

			response.getEvidence().addAll(record.getEvidence().getLogs());
		}

		return response;
	}
}