package com.qaverse.smart.trace.debug;

import com.qaverse.smart.trace.search.*;
import com.qaverse.smart.trace.storage.investigation.InvestigationStore;

public class SearchValidation {

	public static void validate() {

		InvestigationSearchEngine engine = new InvestigationSearchEngine(InvestigationStore.getRepository());

		SearchCriteria criteria = new SearchCriteria();

		criteria.setField(SearchFields.SEVERITY);

		criteria.setOperator(SearchOperator.EQUALS);

		criteria.setValue("CRITICAL");

		SearchResult result = engine.search(criteria);

		System.out.println("[SMART-TRACE] Search Matches : " + result.getCount());
	}
}