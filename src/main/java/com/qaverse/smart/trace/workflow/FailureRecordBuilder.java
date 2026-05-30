package com.qaverse.smart.trace.workflow;

import java.time.LocalDateTime;

import org.testng.ITestResult;

import com.qaverse.smart.trace.core.TraceContextManager;
import com.qaverse.smart.trace.model.failure.FailureRecord;

public final class FailureRecordBuilder {

	private FailureRecordBuilder() {
	}

	public static FailureRecord build(ITestResult result) {

		FailureRecord record = new FailureRecord();

		record.setTraceId(TraceContextManager.getTraceId());

		record.setTestName(result.getMethod().getMethodName());

		record.setFailureTime(LocalDateTime.now());

		Throwable throwable = result.getThrowable();

		if (throwable != null) {

			record.setExceptionType(throwable.getClass().getSimpleName());

			record.setExceptionMessage(throwable.getMessage());
		}

		long duration = result.getEndMillis() - result.getStartMillis();

		record.setExecutionTime(duration);

		return record;
	}
}