package com.qaverse.smart.trace.integration.selenium;

import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureResult;

public class SeleniumFailureCaptureService {

	private final SeleniumArtifactCollector artifactCollector = new SeleniumArtifactCollector();

	public ScreenshotCaptureResult captureFailureEvidence(String traceId) {

		String fileName = "smart-trace-output/screenshots/" + traceId + ".png";

		return artifactCollector.captureScreenshot(fileName);
	}
}