package com.qaverse.smart.trace.storage.investigation;

public final class InvestigationStore {

	private static final InvestigationRepository REPOSITORY = new InMemoryInvestigationRepository();

	private InvestigationStore() {
	}

	public static InvestigationRepository getRepository() {

		return REPOSITORY;
	}
}