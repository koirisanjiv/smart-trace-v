package com.qaverse.smart.trace.trace.evidence;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.trace.step.StepTraceRecorder;
import com.qaverse.smart.trace.trace.step.StepTraceSession;

public class FailureEvidenceAggregator {

	public FailureEvidence aggregate(FailureRecord failureRecord, StepTraceRecorder recorder) {

		FailureEvidence evidence = new FailureEvidence();

		evidence.setTraceId(failureRecord.getTraceId());

		evidence.setTestName(failureRecord.getTestName());

		evidence.setExceptionType(failureRecord.getExceptionType());

		evidence.setExceptionMessage(failureRecord.getExceptionMessage());

		if (failureRecord.getRootCause() != null) {

			evidence.setRootCause(failureRecord.getRootCause().getRootCause());
		}

		if (failureRecord.getArtifacts() != null) {

			evidence.setScreenshotPath(failureRecord.getArtifacts().getScreenshotPath());

			evidence.setPageSourcePath(failureRecord.getArtifacts().getPageSourcePath());

			evidence.setVideoPath(failureRecord.getArtifacts().getVideoPath());
		}

		if (recorder != null) {

			StepTraceSession session = recorder.getSession();

			evidence.getSteps().addAll(session.getSteps());
		}

		return evidence;
	}
}