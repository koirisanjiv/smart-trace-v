package com.qaverse.smart.trace.config;

public class DashboardConfig {

	private boolean enabled = true;

	private boolean projectLevelEnabled = true;

	private boolean masterLevelEnabled = true;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isProjectLevelEnabled() {
		return projectLevelEnabled;
	}

	public void setProjectLevelEnabled(boolean projectLevelEnabled) {
		this.projectLevelEnabled = projectLevelEnabled;
	}

	public boolean isMasterLevelEnabled() {
		return masterLevelEnabled;
	}

	public void setMasterLevelEnabled(boolean masterLevelEnabled) {
		this.masterLevelEnabled = masterLevelEnabled;
	}
}