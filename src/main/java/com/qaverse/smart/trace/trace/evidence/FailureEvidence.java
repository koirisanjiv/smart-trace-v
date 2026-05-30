package com.qaverse.smart.trace.trace.evidence;

import java.util.ArrayList;
import java.util.List;

import com.qaverse.smart.trace.model.failure.StepTrace;

public class FailureEvidence {

	private String traceId;

	private String testName;

	private String screenshotPath;

	private String pageSourcePath;

	private String videoPath;

	private String rootCause;

	private String exceptionType;

	private String exceptionMessage;

	private final List<String> logs = new ArrayList<>();

	private final List<String> consoleErrors = new ArrayList<>();

	private final List<StepTrace> steps = new ArrayList<>();

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {

		this.traceId = traceId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {

		this.testName = testName;
	}

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {

		this.screenshotPath = screenshotPath;
	}

	public String getPageSourcePath() {
		return pageSourcePath;
	}

	public void setPageSourcePath(String pageSourcePath) {

		this.pageSourcePath = pageSourcePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {

		this.videoPath = videoPath;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {

		this.rootCause = rootCause;
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

	public List<String> getLogs() {
		return logs;
	}

	public List<String> getConsoleErrors() {
		return consoleErrors;
	}

	public List<StepTrace> getSteps() {
		return steps;
	}
}