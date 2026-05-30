package com.qaverse.smart.trace.search;

import java.util.ArrayList;
import java.util.List;

import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;

public class SearchResult {

	private final List<InvestigationRecord> investigations = new ArrayList<>();

	public List<InvestigationRecord> getInvestigations() {

		return investigations;
	}

	public int getCount() {

		return investigations.size();
	}
}