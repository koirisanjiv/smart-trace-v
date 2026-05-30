package com.qaverse.smart.trace.trace.similarity;

import java.util.List;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class FailureSimilarityEngine {

	public SimilarityResult analyze(FailureRecord current, List<FailureRecord> history) {

		SimilarityResult result = new SimilarityResult();

		for (FailureRecord previous : history) {

			int score = calculateSimilarity(current, previous);

			if (score >= 70) {

				SimilarFailure match = new SimilarFailure();

				match.setFailureId(previous.getFailureId());

				match.setTestName(previous.getTestName());

				if (previous.getRootCause() != null) {

					match.setRootCause(previous.getRootCause().getRootCause());
				}

				match.setSimilarityScore(score);

				result.add(match);
			}
		}

		return result;
	}

	private int calculateSimilarity(FailureRecord current, FailureRecord previous) {

		int score = 0;

		if (safe(current.getExceptionType()).equalsIgnoreCase(safe(previous.getExceptionType()))) {

			score += 40;
		}

		if (safe(current.getExceptionMessage()).equalsIgnoreCase(safe(previous.getExceptionMessage()))) {

			score += 40;
		}

		if (current.getRootCause() != null && previous.getRootCause() != null
				&& safe(current.getRootCause().getRootCause())
						.equalsIgnoreCase(safe(previous.getRootCause().getRootCause()))) {

			score += 20;
		}

		return score;
	}

	private String safe(String value) {

		return value == null ? "" : value;
	}
}