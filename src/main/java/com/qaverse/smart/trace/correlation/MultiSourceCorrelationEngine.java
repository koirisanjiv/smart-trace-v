package com.qaverse.smart.trace.correlation;

public class MultiSourceCorrelationEngine {

	private final ScreenshotLogCorrelator screenshotLogCorrelator = new ScreenshotLogCorrelator();

	private final NetworkDomCorrelator networkDomCorrelator = new NetworkDomCorrelator();

	public CorrelationResult correlate(Throwable throwable, String logs, long apiTime, boolean domUpdated) {

		CorrelationResult result = new CorrelationResult();

		String screenshotEvidence = screenshotLogCorrelator.correlate("NA", logs);

		String networkEvidence = networkDomCorrelator.correlate(apiTime, domUpdated);

		result.addEvidence(screenshotEvidence);

		result.addEvidence(networkEvidence);

		result.setRootCause(throwable.getMessage());

		result.setConfidence(85);

		return result;
	}
}