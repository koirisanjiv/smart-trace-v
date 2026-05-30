package com.qaverse.smart.trace.dashboard;

import java.util.Map;

import com.qaverse.smart.trace.visualization.TraceVisualizationEngine;

public class InvestigationDataProvider {

	private final TraceVisualizationEngine visualizationEngine = new TraceVisualizationEngine();

	public Map<String, Object> loadData() {

		return visualizationEngine.buildVisualization();
	}
}