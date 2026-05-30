package com.qaverse.smart.trace.api.investigation;

import java.util.List;
import java.util.stream.Collectors;

import com.qaverse.smart.trace.storage.investigation.InvestigationRepository;
import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;

public class InvestigationController {

	private final InvestigationRepository repository;

	private final InvestigationMapper mapper = new InvestigationMapper();

	public InvestigationController(InvestigationRepository repository) {

		this.repository = repository;
	}

	public InvestigationResponse getInvestigation(String failureId) {

		InvestigationRecord record = repository.findByFailureId(failureId);

		return mapper.map(record);
	}

	public List<InvestigationResponse> getAllInvestigations() {

		return repository.findAll().stream().map(mapper::map).collect(Collectors.toList());
	}

	public long totalInvestigations() {

		return repository.count();
	}
}