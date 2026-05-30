package com.qaverse.smart.trace.pipeline;

public class CapturePipeline implements PipelineStage {

	@Override
	public String getName() {

		return "CapturePipeline";
	}

	@Override
	public void execute(PipelineContext context) {

		System.out.println("[SMART-TRACE] Capture Pipeline");

		context.put("capture.completed", true);
	}
}