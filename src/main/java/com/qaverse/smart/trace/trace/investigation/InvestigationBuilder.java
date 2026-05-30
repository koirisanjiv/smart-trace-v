package com.qaverse.smart.trace.trace.investigation;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.trace.evidence.FailureEvidence;
import com.qaverse.smart.trace.trace.fingerprint.FailureFingerprint;
import com.qaverse.smart.trace.trace.rootcause.RootCauseTree;
import com.qaverse.smart.trace.trace.similarity.SimilarityResult;

public class InvestigationBuilder {

	public InvestigationRecord build(FailureRecord failure, FailureEvidence evidence, FailureFingerprint fingerprint,
			SimilarityResult similarity, RootCauseTree tree) {

		InvestigationRecord record = new InvestigationRecord();

		record.setFailure(failure);

		record.setEvidence(evidence);

		record.setFingerprint(fingerprint);

		record.setSimilarity(similarity);

		record.setRootCauseTree(tree);

		return record;
	}
}