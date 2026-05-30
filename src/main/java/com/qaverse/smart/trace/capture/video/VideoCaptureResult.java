package com.qaverse.smart.trace.capture.video;

public class VideoCaptureResult {

	private boolean success;

	private String videoUrl;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {

		this.success = success;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {

		this.videoUrl = videoUrl;
	}
}