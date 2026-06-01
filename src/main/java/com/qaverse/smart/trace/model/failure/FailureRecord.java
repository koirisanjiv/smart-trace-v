package com.qaverse.smart.trace.model.failure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.qaverse.smart.trace.trace.rootcause.RootCauseTree;

public class FailureRecord {

	private final String failureId = UUID.randomUUID().toString();

	private String traceId;

	private String projectName;

	private String testName;

	private String exceptionType;

	private String exceptionMessage;

	private LocalDateTime failureTime = LocalDateTime.now();

	private long executionTime;

	private TraceRecord trace;

	private RootCauseRecord rootCause;

	private ArtifactRecord artifacts;

	private CorrelationRecord correlation;

	private FailureTimeline timeline;

	private RootCauseTree rootCauseTree;

	private final List<String> recommendations = new ArrayList<>();

	private final List<StepTrace> stepTraces = new ArrayList<>();

	private String fingerprintId;



	public String getFailureId() {

		return failureId;
	}

	public String getTraceId() {

		return traceId;
	}

	public void setTraceId(String traceId) {

		this.traceId = traceId;
	}

	public String getProjectName() {

		return projectName;
	}

	public void setProjectName(String projectName) {

		this.projectName = projectName;
	}

	public String getTestName() {

		return testName;
	}

	public void setTestName(String testName) {

		this.testName = testName;
	}

	public String getExceptionType() {

		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {

		this.exceptionType = exceptionType;
	}

	public String getExceptionMessage() {

		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {

		this.exceptionMessage = exceptionMessage;
	}

	public LocalDateTime getFailureTime() {

		return failureTime;
	}

	public void setFailureTime(LocalDateTime failureTime) {

		this.failureTime = failureTime;
	}

	public String getFailureTimestamp() {

		return failureTime == null ? null : failureTime.toString();
	}

	public long getExecutionTime() {

		return executionTime;
	}

	public void setExecutionTime(long executionTime) {

		this.executionTime = executionTime;
	}

	public TraceRecord getTrace() {

		return trace;
	}

	public void setTrace(TraceRecord trace) {

		this.trace = trace;
	}

	public RootCauseRecord getRootCause() {

		return rootCause;
	}

	public void setRootCause(RootCauseRecord rootCause) {

		this.rootCause = rootCause;
	}

	public boolean hasRootCause() {

		return rootCause != null;
	}

	public ArtifactRecord getArtifacts() {

		return artifacts;
	}

	public void setArtifacts(ArtifactRecord artifacts) {

		this.artifacts = artifacts;
	}

	public CorrelationRecord getCorrelation() {

		return correlation;
	}

	public void setCorrelation(CorrelationRecord correlation) {

		this.correlation = correlation;
	}

	public FailureTimeline getTimeline() {

		return timeline;
	}

	public void setTimeline(FailureTimeline timeline) {

		this.timeline = timeline;
	}

	public boolean hasTimeline() {

		return timeline != null;
	}

	public RootCauseTree getRootCauseTree() {

		return rootCauseTree;
	}

	public void setRootCauseTree(RootCauseTree rootCauseTree) {

		this.rootCauseTree = rootCauseTree;
	}

	public List<String> getRecommendations() {

		return recommendations;
	}

	public void addRecommendation(String recommendation) {

		if (recommendation != null && !recommendation.isEmpty()) {

			recommendations.add(recommendation);
		}
	}

	public List<StepTrace> getStepTraces() {

		return stepTraces;
	}

	public void addStepTrace(StepTrace step) {

		if (step != null) {

			stepTraces.add(step);
		}
	}

	public String getFingerprintId() {
		return fingerprintId;
	}

	public void setFingerprintId(String fingerprintId) {
		this.fingerprintId = fingerprintId;
	}

	@Override
	public String toString() {

		return "FailureRecord{" + "failureId='" + failureId + '\'' + ", traceId='" + traceId + '\'' + ", projectName='"
				+ projectName + '\'' + ", testName='" + testName + '\'' + ", exceptionType='" + exceptionType + '\''
				+ ", failureTime=" + failureTime + ", executionTime=" + executionTime + '}';
	}
}