package com.qaverse.smart.trace.model.failure;

public class ArtifactRecord {

	private String screenshotPath;

	private String pageSourcePath;

	private String videoPath;

	private String logPath;

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

	public String getLogPath() {
		return logPath;
	}

	public void setLogPath(String logPath) {

		this.logPath = logPath;
	}
}