package com.qaverse.smart.trace.capture;

import org.openqa.selenium.WebDriver;

import com.qaverse.smart.trace.capture.page.PageSourceCaptureResult;
import com.qaverse.smart.trace.capture.page.PageSourceCaptureService;
import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureResult;
import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureService;

public class ArtifactCaptureCoordinator {

	private final ScreenshotCaptureService screenshotService = new ScreenshotCaptureService();

	private final PageSourceCaptureService pageSourceService = new PageSourceCaptureService();

	public ArtifactBundle capture(WebDriver driver, String traceId) {

		ArtifactBundle bundle = new ArtifactBundle();

		ScreenshotCaptureResult screenshot = screenshotService.capture(driver,
				"smart-trace-output/screenshots/" + traceId + ".png");

		PageSourceCaptureResult page = pageSourceService.capture(driver,
				"smart-trace-output/pages/" + traceId + ".html");

		bundle.setScreenshotPath(screenshot.getScreenshotPath());

		bundle.setPageSourcePath(page.getFilePath());

		return bundle;
	}
}