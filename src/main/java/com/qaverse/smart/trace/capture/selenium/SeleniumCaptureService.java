package com.qaverse.smart.trace.capture.selenium;

import org.openqa.selenium.WebDriver;

import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureResult;
import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureService;

public class SeleniumCaptureService {

	private final ScreenshotCaptureService screenshotCaptureService = new ScreenshotCaptureService();

	public ScreenshotCaptureResult captureFailureEvidence(WebDriver driver, String screenshotFile) {

		return screenshotCaptureService.capture(driver, screenshotFile);
	}
}