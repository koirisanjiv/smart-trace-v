package com.qaverse.smart.trace.model.failure;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TraceRecord {

	private String traceId;

	private String sessionId;

	private String testName;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private long duration;

	private final List<StepTrace> stepTraces = new ArrayList<>();

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {

		this.traceId = traceId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {

		this.sessionId = sessionId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {

		this.testName = testName;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {

		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {

		this.endTime = endTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {

		this.duration = duration;
	}

	public List<StepTrace> getStepTraces() {

		return stepTraces;
	}

	public void addStepTrace(StepTrace step) {

		if (step != null) {

			stepTraces.add(step);
		}
	}
}