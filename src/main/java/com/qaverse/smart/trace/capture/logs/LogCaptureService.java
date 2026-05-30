package com.qaverse.smart.trace.capture.logs;

import com.qaverse.smart.trace.core.event.TraceEvent;
import com.qaverse.smart.trace.core.event.TraceEventBus;
import com.qaverse.smart.trace.core.event.TraceEventType;

public class LogCaptureService {

	public LogCaptureService(TraceEventBus eventBus) {

		eventBus.subscribe(TraceEventType.TEST_FAILED, this::captureLogs);
	}

	private void captureLogs(TraceEvent event) {

		System.out.println("Capturing logs for trace : " + event.getPayload().get("traceId"));
	}
}