package com.qaverse.smart.trace.config;

public class VisualizationConfig {

	private boolean heatmapEnabled = true;

	private boolean timelineEnabled = true;

	private boolean graphEnabled = true;

	public boolean isHeatmapEnabled() {
		return heatmapEnabled;
	}

	public void setHeatmapEnabled(boolean heatmapEnabled) {
		this.heatmapEnabled = heatmapEnabled;
	}

	public boolean isTimelineEnabled() {
		return timelineEnabled;
	}

	public void setTimelineEnabled(boolean timelineEnabled) {
		this.timelineEnabled = timelineEnabled;
	}

	public boolean isGraphEnabled() {
		return graphEnabled;
	}

	public void setGraphEnabled(boolean graphEnabled) {
		this.graphEnabled = graphEnabled;
	}
}