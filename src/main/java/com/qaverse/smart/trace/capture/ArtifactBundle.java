package com.qaverse.smart.trace.capture;

public class ArtifactBundle {

	private String screenshotPath;

	private String pageSourcePath;

	private String videoPath;

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {

		this.screenshotPath = screenshotPath;
	}

	public String getPageSourcePath() {
		return pageSourcePath;
	}

	public void setPageSourcePath(String pageSourcePath) {

		this.pageSourcePath = pageSourcePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {

		this.videoPath = videoPath;
	}
}