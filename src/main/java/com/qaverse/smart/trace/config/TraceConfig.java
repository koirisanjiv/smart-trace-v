package com.qaverse.smart.trace.config;

public class TraceConfig {

	private CaptureConfig captureConfig = new CaptureConfig();

	private DashboardConfig dashboardConfig = new DashboardConfig();

	private StorageConfig storageConfig = new StorageConfig();

	private PerformanceConfig performanceConfig = new PerformanceConfig();

	private VisualizationConfig visualizationConfig = new VisualizationConfig();

	private AiConfig aiConfig = new AiConfig();

	public CaptureConfig getCaptureConfig() {
		return captureConfig;
	}

	public DashboardConfig getDashboardConfig() {
		return dashboardConfig;
	}

	public StorageConfig getStorageConfig() {
		return storageConfig;
	}

	public PerformanceConfig getPerformanceConfig() {
		return performanceConfig;
	}

	public VisualizationConfig getVisualizationConfig() {
		return visualizationConfig;
	}

	public AiConfig getAiConfig() {
		return aiConfig;
	}
}