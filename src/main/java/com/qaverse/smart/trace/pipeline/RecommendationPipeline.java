package com.qaverse.smart.trace.pipeline;

public class RecommendationPipeline implements PipelineStage {

	@Override
	public String getName() {

		return "RecommendationPipeline";
	}

	@Override
	public void execute(PipelineContext context) {

		System.out.println("[SMART-TRACE] Recommendation Pipeline");

		context.put("recommendation.completed", true);
	}
}