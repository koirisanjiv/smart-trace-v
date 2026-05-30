package com.qaverse.smart.trace.pipeline;

public class PipelineOrchestrator {

	private final PipelineExecutor executor = new PipelineExecutor();

	public void register(PipelineStage stage) {

		executor.addStage(stage);
	}

	public void execute(PipelineContext context) {

		executor.execute(context);
	}
}