package com.qaverse.smart.trace.search;

import java.util.List;

import com.qaverse.smart.trace.storage.investigation.InvestigationRepository;
import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;
import com.qaverse.smart.trace.trace.investigation.InvestigationSummary;

public class InvestigationSearchEngine {

	private final InvestigationRepository repository;

	public InvestigationSearchEngine(InvestigationRepository repository) {

		this.repository = repository;
	}

	public SearchResult search(SearchCriteria criteria) {

		SearchResult result = new SearchResult();

		List<InvestigationRecord> investigations = repository.findAll();

		for (InvestigationRecord investigation : investigations) {

			if (matches(investigation, criteria)) {

				result.getInvestigations().add(investigation);
			}
		}

		return result;
	}

	private boolean matches(InvestigationRecord investigation, SearchCriteria criteria) {

		String actualValue = extractFieldValue(investigation, criteria.getField());

		if (actualValue == null) {

			return false;
		}

		String expectedValue = criteria.getValue();

		if (expectedValue == null) {
			return false;
		}

		switch (criteria.getOperator()) {

		case EQUALS:

			return actualValue.equalsIgnoreCase(expectedValue);

		case CONTAINS:

			return actualValue.toLowerCase().contains(expectedValue.toLowerCase());

		case STARTS_WITH:

			return actualValue.toLowerCase().startsWith(expectedValue.toLowerCase());

		case ENDS_WITH:

			return actualValue.toLowerCase().endsWith(expectedValue.toLowerCase());

		default:

			return false;
		}
	}

	private String extractFieldValue(InvestigationRecord investigation, SearchFields field) {

		if (investigation == null) {

			return null;
		}

		InvestigationSummary summary = investigation.getSummary();

		switch (field) {

		case FAILURE_ID:

			return investigation.getFailure() == null ? null : investigation.getFailure().getFailureId();

		case TEST_NAME:

			return investigation.getFailure() == null ? null : investigation.getFailure().getTestName();

		case ROOT_CAUSE:

			return summary == null ? null : summary.getRootCause();

		case SEVERITY:

			return summary == null ? null : summary.getSeverity();

		case PRIORITY:

			return summary == null ? null : summary.getPriority();

		case FINGERPRINT:

			return summary == null ? null : summary.getFingerprintId();

		case EXCEPTION_TYPE:

			return investigation.getFailure() == null ? null : investigation.getFailure().getExceptionType();

		case TRACE_ID:

			return investigation.getFailure() == null ? null : investigation.getFailure().getTraceId();

		case CATEGORY:

			return investigation.getFailure() == null || investigation.getFailure().getRootCause() == null ? null
					: investigation.getFailure().getRootCause().getCategory();

		default:

			return null;
		}
	}
}