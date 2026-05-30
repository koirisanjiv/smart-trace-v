package com.qaverse.smart.trace.trace.similarity;

import java.util.List;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.storage.FailureRepository;

public class SimilarityManager {

	private final FailureSimilarityEngine engine = new FailureSimilarityEngine();

	private final FailureRepository repository = new FailureRepository();

	public SimilarityResult analyze(FailureRecord failure) {

		List<FailureRecord> history = repository.findAll();

		return engine.analyze(failure, history);
	}
}