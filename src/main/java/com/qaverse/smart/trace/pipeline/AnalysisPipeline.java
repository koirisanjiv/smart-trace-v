package com.qaverse.smart.trace.pipeline;

public class AnalysisPipeline implements PipelineStage {

	@Override
	public String getName() {

		return "AnalysisPipeline";
	}

	@Override
	public void execute(PipelineContext context) {

		System.out.println("[SMART-TRACE] Analysis Pipeline");

		context.put("analysis.completed", true);
	}
}