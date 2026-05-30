package com.qaverse.smart.trace.model.failure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StepTrace {

	private String stepId;

	private String stepName;

	private StepStatus status;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private String failureReason;

	private String locator;

	private String screenshotPath;

	private final List<StepTrace> stepTraces = new ArrayList<>();

	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public StepStatus getStatus() {
		return status;
	}

	public void setStatus(StepStatus status) {
		this.status = status;
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

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {

		this.failureReason = failureReason;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {

		this.locator = locator;
	}

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {

		this.screenshotPath = screenshotPath;
	}

	public List<StepTrace> getStepTraces() {

		return stepTraces;
	}

	public void addStepTrace(StepTrace step) {

		stepTraces.add(step);
	}
}