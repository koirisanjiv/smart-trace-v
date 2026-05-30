package com.qaverse.smart.trace.pipeline;

public interface PipelineStage {

	String getName();

	void execute(PipelineContext context);
}