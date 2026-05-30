package com.qaverse.smart.trace.visualization;

import java.util.HashMap;
import java.util.Map;

public class TraceVisualizationEngine {

	private final TimelineRenderer timelineBuilder = new TimelineRenderer();

	private final FailureGraphBuilder graphBuilder = new FailureGraphBuilder();

	private final HeatmapBuilder heatmapBuilder = new HeatmapBuilder();

	private final ExecutionFlowRenderer flowRenderer = new ExecutionFlowRenderer();

	public Map<String, Object> buildVisualization() {

		Map<String, Object> data = new HashMap<>();

		data.put("timeline", timelineBuilder.build());

		data.put("graph", graphBuilder.getNodes());

		data.put("heatmap", heatmapBuilder.build());

		data.put("executionFlow", flowRenderer.render());

		return data;
	}

	public TimelineRenderer getTimelineBuilder() {

		return timelineBuilder;
	}

	public FailureGraphBuilder getGraphBuilder() {

		return graphBuilder;
	}

	public HeatmapBuilder getHeatmapBuilder() {

		return heatmapBuilder;
	}

	public ExecutionFlowRenderer getFlowRenderer() {

		return flowRenderer;
	}
}