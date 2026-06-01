package com.qaverse.smart.trace.trace.similarity;

import java.util.List;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.storage.investigation.InvestigationRepository;
import com.qaverse.smart.trace.storage.investigation.InvestigationStore;
import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;

public class SimilarityManager {

	private final FailureSimilarityEngine engine = new FailureSimilarityEngine();

	private final InvestigationRepository repository = InvestigationStore.getRepository();

	public SimilarityResult analyze(FailureRecord failure) {
		List<InvestigationRecord> investigations = repository.findAll();

		List<FailureRecord> history = investigations.stream().map(InvestigationRecord::getFailure)
				.filter(f -> f != null).toList();

		System.out.println("[SMART-TRACE] Historical Failures : " + history.size());
		return engine.analyze(failure, history);
	}
}