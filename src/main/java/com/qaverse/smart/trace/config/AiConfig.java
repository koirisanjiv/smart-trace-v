package com.qaverse.smart.trace.config;

public class AiConfig {

	private boolean enabled = false;

	private String provider = "NONE";

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}
}