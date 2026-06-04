package com.qaverse.smart.trace.capture;

import org.openqa.selenium.WebDriver;

import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureResult;
import com.qaverse.smart.trace.capture.screenshots.ScreenshotCaptureService;
import com.qaverse.smart.trace.capture.video.VideoCaptureResult;
import com.qaverse.smart.trace.capture.video.VideoCaptureService;
import com.qaverse.smart.trace.model.failure.ArtifactRecord;

public class ArtifactCaptureCoordinator {

	private final ScreenshotCaptureService screenshotService = new ScreenshotCaptureService();

	//private final VideoCaptureService videoService = new VideoCaptureService();

	public ArtifactRecord capture(WebDriver driver, String failureId, String projectName) {

		ArtifactRecord artifact = new ArtifactRecord();

		String screenshotFile = "Reports/" + projectName + "/smart-trace/screenshots/" + failureId + ".png";

		ScreenshotCaptureResult screenshot = screenshotService.capture(driver, screenshotFile);

		if (screenshot.isSuccess()) {

			artifact.setScreenshotPath(screenshot.getScreenshotPath());	
		}

//		VideoCaptureResult video = videoService.capture(failureId);
//
//		if (video.isSuccess()) {
//
//			artifact.setVideoPath(video.getVideoUrl());
//		}

		return artifact;
	}
}