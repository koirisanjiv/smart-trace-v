package com.qaverse.smart.trace.storage.investigation;

import java.util.List;

import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;

public interface InvestigationRepository {

	void save(InvestigationRecord record);

	InvestigationRecord findByFailureId(String failureId);

	List<InvestigationRecord> findAll();

	long count();
}