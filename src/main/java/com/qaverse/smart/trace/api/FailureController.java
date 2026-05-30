package com.qaverse.smart.trace.api;

import java.util.HashMap;
import java.util.Map;

import com.qaverse.smart.trace.intelligence.SmartDiagnosisEngine;
import com.qaverse.smart.trace.model.diagnosis.DiagnosisResult;
import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.model.failure.RootCauseRecord;

public class FailureController {

	private final SmartDiagnosisEngine diagnosisEngine = new SmartDiagnosisEngine();

	public DiagnosisResult diagnose(Throwable throwable, String logs, long apiResponseTime, boolean domUpdated) {

		return diagnosisEngine.diagnose(throwable, logs, apiResponseTime, domUpdated);
	}

	public Map<String, Object> summary(DiagnosisResult result) {

		Map<String, Object> response = new HashMap<>();

		if (result == null || result.getFailureRecord() == null) {

			return response;
		}

		FailureRecord failureRecord = result.getFailureRecord();

		RootCauseRecord rootCause = failureRecord.getRootCause();

		if (rootCause != null) {

			response.put("rootCause", rootCause.getRootCause());

			response.put("confidence", rootCause.getConfidence());

			response.put("severity", rootCause.getSeverity());

			response.put("priority", rootCause.getPriority());
		}

		response.put("failureId", failureRecord.getFailureId());

		response.put("testName", failureRecord.getTestName());

		return response;
	}
}