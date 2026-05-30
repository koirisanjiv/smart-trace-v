package com.qaverse.smart.trace.observability;

public class EngineTelemetry {

	private final TraceMetricsCollector metricsCollector = new TraceMetricsCollector();

	public void recordTestStart() {

		metricsCollector.increment("tests.started");
	}

	public void recordTestFailure() {

		metricsCollector.increment("tests.failed");
	}

	public void recordTestPass() {

		metricsCollector.increment("tests.passed");
	}

	public void recordCorrelation() {

		metricsCollector.increment("correlation.executed");
	}

	public void recordDiagnosis() {

		metricsCollector.increment("diagnosis.executed");
	}

	public TraceMetricsCollector getMetricsCollector() {

		return metricsCollector;
	}
}