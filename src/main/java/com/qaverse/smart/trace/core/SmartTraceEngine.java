package com.qaverse.smart.trace.core;

import com.qaverse.smart.trace.core.event.TraceEvent;
import com.qaverse.smart.trace.core.event.TraceEventBus;
import com.qaverse.smart.trace.core.event.TraceEventType;

public class SmartTraceEngine {

	private final TraceEventBus eventBus;

	public SmartTraceEngine(TraceEventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void startTest(String testName) {

		TraceContextManager.start();

		eventBus.publish(new TraceEvent(TraceEventType.TEST_STARTED).add("testName", testName).add("traceId",
				TraceContextManager.getTraceId()));
	}

	public void failTest(String testName, Throwable throwable) {

		eventBus.publish(new TraceEvent(TraceEventType.TEST_FAILED).add("testName", testName)
				.add("exception", throwable).add("traceId", TraceContextManager.getTraceId()));
	}

	public void passTest(String testName) {

		eventBus.publish(new TraceEvent(TraceEventType.TEST_PASSED).add("testName", testName).add("traceId",
				TraceContextManager.getTraceId()));

		TraceContextManager.clear();
	}
}