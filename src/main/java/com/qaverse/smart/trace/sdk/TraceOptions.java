package com.qaverse.smart.trace.sdk;

public class TraceOptions {

	private boolean screenshotEnabled = true;
	private boolean videoEnabled = false;
	private boolean dashboardEnabled = true;
	private boolean asyncEnabled = true;
	private boolean storeJson = true;
	private String storageDirectory = "smart-trace-output";

	public boolean isScreenshotEnabled() {
		return screenshotEnabled;
	}

	public void setScreenshotEnabled(boolean screenshotEnabled) {
		this.screenshotEnabled = screenshotEnabled;
	}

	public boolean isVideoEnabled() {
		return videoEnabled;
	}

	public void setVideoEnabled(boolean videoEnabled) {
		this.videoEnabled = videoEnabled;
	}

	public boolean isDashboardEnabled() {
		return dashboardEnabled;
	}

	public void setDashboardEnabled(boolean dashboardEnabled) {
		this.dashboardEnabled = dashboardEnabled;
	}

	public boolean isAsyncEnabled() {
		return asyncEnabled;
	}

	public void setAsyncEnabled(boolean asyncEnabled) {
		this.asyncEnabled = asyncEnabled;
	}

	public boolean isStoreJson() {
		return storeJson;
	}

	public void setStoreJson(boolean storeJson) {
		this.storeJson = storeJson;
	}

	public String getStorageDirectory() {
		return storageDirectory;
	}

	public void setStorageDirectory(String storageDirectory) {
		this.storageDirectory = storageDirectory;
	}
}