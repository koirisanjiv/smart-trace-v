package com.qaverse.smart.trace.pipeline;

public class TracePipeline {

	private final PipelineOrchestrator orchestrator = new PipelineOrchestrator();

	public TracePipeline() {

		orchestrator.register(new CapturePipeline());

		orchestrator.register(new AnalysisPipeline());

		orchestrator.register(new CorrelationPipeline());

		orchestrator.register(new RecommendationPipeline());

		orchestrator.register(new VisualizationPipeline());
	}

	public void execute(PipelineContext context) {

		orchestrator.execute(context);
	}
}