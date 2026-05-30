package com.qaverse.smart.trace.pipeline;

public class VisualizationPipeline implements PipelineStage {

	@Override
	public String getName() {

		return "VisualizationPipeline";
	}

	@Override
	public void execute(PipelineContext context) {

		System.out.println("[SMART-TRACE] Visualization Pipeline");

		context.put("visualization.completed", true);
	}
}