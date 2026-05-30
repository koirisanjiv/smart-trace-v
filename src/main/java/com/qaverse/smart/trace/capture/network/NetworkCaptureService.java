package com.qaverse.smart.trace.capture.network;

public class NetworkCaptureService {

	private long lastResponseTime;

	public void recordResponseTime(long responseTime) {

		this.lastResponseTime = responseTime;
	}

	public long getLastResponseTime() {

		return lastResponseTime;
	}

	public boolean isSlowResponse() {

		return lastResponseTime > 5000;
	}
}