package com.qaverse.smart.trace.integration.selenium;

import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureResult;
import com.qaverse.smart.trace.core.event.TraceEvent;
import com.qaverse.smart.trace.core.event.TraceEventBus;
import com.qaverse.smart.trace.core.event.TraceEventType;

public class SeleniumTraceSubscriber {

	private final SeleniumFailureCaptureService captureService = new SeleniumFailureCaptureService();

	public SeleniumTraceSubscriber(TraceEventBus eventBus) {

		eventBus.subscribe(TraceEventType.TEST_FAILED, this::onFailure);
	}

	private void onFailure(TraceEvent event) {

		String traceId = String.valueOf(event.getPayload().get("traceId"));

		ScreenshotCaptureResult result = captureService.captureFailureEvidence(traceId);

		if (result.isSuccess()) {

			System.out.println("[SMART-TRACE] Screenshot Captured : " + result.getScreenshotPath());
		}
	}
}