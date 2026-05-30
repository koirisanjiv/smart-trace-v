package com.qaverse.smart.trace.trace.similarity;

import java.util.ArrayList;
import java.util.List;

public class SimilarityResult {

	private final List<SimilarFailure> similarFailures = new ArrayList<>();

	public List<SimilarFailure> getSimilarFailures() {

		return similarFailures;
	}

	public void add(SimilarFailure failure) {

		similarFailures.add(failure);
	}

	public boolean hasMatches() {

		return !similarFailures.isEmpty();
	}

	public int size() {

		return similarFailures.size();
	}
}