package com.qaverse.smart.trace.storage.investigation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;

public class InMemoryInvestigationRepository implements InvestigationRepository {

	private final Map<String, InvestigationRecord> records = new ConcurrentHashMap<>();

	@Override
	public void save(InvestigationRecord record) {

		records.put(record.getFailureId(), record);
	}

	@Override
	public InvestigationRecord findByFailureId(String failureId) {

		return records.get(failureId);
	}

	@Override
	public List<InvestigationRecord> findAll() {

		return new ArrayList<>(records.values());
	}

	@Override
	public long count() {

		return records.size();
	}
}