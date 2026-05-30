package com.qaverse.smart.trace.integration.selenium;

import org.openqa.selenium.WebDriver;

import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureResult;
import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureService;

public class SeleniumArtifactCollector {

	private final ScreenshotCaptureService screenshotService = new ScreenshotCaptureService();

	public ScreenshotCaptureResult captureScreenshot(String screenshotPath) {

		WebDriver driver = SeleniumContext.getProvider().getDriver();

		if (driver == null) {

			ScreenshotCaptureResult result = new ScreenshotCaptureResult();

			result.setSuccess(false);

			return result;
		}

		return screenshotService.capture(driver, screenshotPath);
	}
}