package com.qaverse.smart.trace.config;

public class StorageConfig {

	private boolean inMemoryEnabled = true;

	private boolean jsonExportEnabled = true;

	private String storagePath = "smart-trace-output";

	public boolean isInMemoryEnabled() {
		return inMemoryEnabled;
	}

	public void setInMemoryEnabled(boolean inMemoryEnabled) {
		this.inMemoryEnabled = inMemoryEnabled;
	}

	public boolean isJsonExportEnabled() {
		return jsonExportEnabled;
	}

	public void setJsonExportEnabled(boolean jsonExportEnabled) {
		this.jsonExportEnabled = jsonExportEnabled;
	}

	public String getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}
}