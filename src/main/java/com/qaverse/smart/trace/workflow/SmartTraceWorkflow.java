package com.qaverse.smart.trace.workflow;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.storage.investigation.InvestigationRepository;
import com.qaverse.smart.trace.storage.investigation.InvestigationStore;
import com.qaverse.smart.trace.trace.evidence.FailureEvidence;
import com.qaverse.smart.trace.trace.evidence.FailureEvidenceAggregator;
import com.qaverse.smart.trace.trace.fingerprint.FailureFingerprint;
import com.qaverse.smart.trace.trace.fingerprint.FingerprintManager;
import com.qaverse.smart.trace.trace.investigation.FailureInvestigationEngine;
import com.qaverse.smart.trace.trace.investigation.InvestigationBuilder;
import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;
import com.qaverse.smart.trace.trace.investigation.InvestigationSummary;
import com.qaverse.smart.trace.trace.rootcause.RootCauseTree;
import com.qaverse.smart.trace.trace.rootcause.RootCauseTreeBuilder;
import com.qaverse.smart.trace.trace.similarity.SimilarityManager;
import com.qaverse.smart.trace.trace.similarity.SimilarityResult;
import com.qaverse.smart.trace.trace.step.StepTraceRecorder;

public class SmartTraceWorkflow {

	private final FailureEvidenceAggregator evidenceAggregator = new FailureEvidenceAggregator();

	private final FingerprintManager fingerprintManager = new FingerprintManager();

	private final SimilarityManager similarityManager = new SimilarityManager();

	private final RootCauseTreeBuilder rootCauseTreeBuilder = new RootCauseTreeBuilder();

	private final InvestigationBuilder investigationBuilder = new InvestigationBuilder();

	private final FailureInvestigationEngine investigationEngine = new FailureInvestigationEngine();

	public InvestigationRecord investigate(FailureRecord failureRecord, StepTraceRecorder recorder) {

		FailureEvidence evidence = evidenceAggregator.aggregate(failureRecord, recorder);

		if (recorder != null) {
			recorder.getSession().getSteps().forEach(failureRecord::addStepTrace);
		}

		FailureFingerprint fingerprint = fingerprintManager.process(failureRecord);

		failureRecord.setFingerprintId(fingerprint.getFingerprintId());

		SimilarityResult similarity = similarityManager.analyze(failureRecord);

		System.out.println("[SMART-TRACE] Similar Failures : " + similarity.size());

		RootCauseTree tree = rootCauseTreeBuilder.build(failureRecord);

		InvestigationRecord record = investigationBuilder.build(failureRecord, evidence, fingerprint, similarity, tree);

		InvestigationSummary summary = investigationEngine.summarize(failureRecord);

		summary.setFingerprintId(fingerprint.getFingerprintId());

		summary.setSimilarFailures(similarity.size());

		record.setSummary(summary);

		return record;
	}
}