package com.qaverse.smart.trace.capture.screenshots;

public class ScreenshotCaptureResult {

	private String screenshotPath;

	private boolean success;

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}