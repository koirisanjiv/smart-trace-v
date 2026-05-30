package com.qaverse.smart.trace.config;

public class CaptureConfig {

	private boolean screenshotsEnabled = true;

	private boolean logsEnabled = true;

	private boolean videoEnabled = false;

	private boolean networkEnabled = true;

	public boolean isScreenshotsEnabled() {
		return screenshotsEnabled;
	}

	public void setScreenshotsEnabled(boolean screenshotsEnabled) {
		this.screenshotsEnabled = screenshotsEnabled;
	}

	public boolean isLogsEnabled() {
		return logsEnabled;
	}

	public void setLogsEnabled(boolean logsEnabled) {
		this.logsEnabled = logsEnabled;
	}

	public boolean isVideoEnabled() {
		return videoEnabled;
	}

	public void setVideoEnabled(boolean videoEnabled) {
		this.videoEnabled = videoEnabled;
	}

	public boolean isNetworkEnabled() {
		return networkEnabled;
	}

	public void setNetworkEnabled(boolean networkEnabled) {
		this.networkEnabled = networkEnabled;
	}
}