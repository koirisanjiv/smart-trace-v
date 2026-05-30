package com.qaverse.smart.trace.pipeline;

import java.util.ArrayList;
import java.util.List;

public class PipelineExecutor {

	private final List<PipelineStage> stages = new ArrayList<>();

	public void addStage(PipelineStage stage) {

		stages.add(stage);
	}

	public void execute(PipelineContext context) {

		for (PipelineStage stage : stages) {

			stage.execute(context);
		}
	}
}