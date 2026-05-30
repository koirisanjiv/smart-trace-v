package com.qaverse.smart.trace.pipeline;

public class CorrelationPipeline implements PipelineStage {

	@Override
	public String getName() {

		return "CorrelationPipeline";
	}

	@Override
	public void execute(PipelineContext context) {

		System.out.println("[SMART-TRACE] Correlation Pipeline");

		context.put("correlation.completed", true);
	}
}