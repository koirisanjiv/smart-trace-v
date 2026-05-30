package com.qaverse.smart.trace.config;

public class PerformanceConfig {

	private boolean asyncEnabled = true;

	private int threadPoolSize = 4;

	private int bufferSize = 500;

	public boolean isAsyncEnabled() {
		return asyncEnabled;
	}

	public void setAsyncEnabled(boolean asyncEnabled) {
		this.asyncEnabled = asyncEnabled;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}
}