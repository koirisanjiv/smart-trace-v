package com.qaverse.smart.trace.classifier;

import com.qaverse.smart.trace.core.event.TraceEvent;
import com.qaverse.smart.trace.core.event.TraceEventBus;
import com.qaverse.smart.trace.core.event.TraceEventType;

public class FailureClassificationEngine {

	public FailureClassificationEngine(TraceEventBus eventBus) {

		eventBus.subscribe(TraceEventType.TEST_FAILED, this::classify);
	}

	private void classify(TraceEvent event) {

		Throwable throwable = (Throwable) event.getPayload().get("exception");

		String classification = classifyException(throwable);

		System.out.println("Failure Classification : " + classification);
	}

	private String classifyException(Throwable throwable) {

		if (throwable == null) {

			return "UNKNOWN_FAILURE";
		}

		String name = throwable.getClass().getSimpleName();

		if (name.contains("Timeout")) {
			return "TIMING_FAILURE";
		}

		if (name.contains("NoSuchElement")) {
			return "LOCATOR_FAILURE";
		}

		if (name.contains("Assertion")) {
			return "ASSERTION_FAILURE";
		}

		return "UNKNOWN_FAILURE";
	}
}