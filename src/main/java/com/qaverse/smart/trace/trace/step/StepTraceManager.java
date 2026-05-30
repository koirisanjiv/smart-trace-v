package com.qaverse.smart.trace.trace.step;

public final class StepTraceManager {

	private static final ThreadLocal<StepTraceRecorder> RECORDER = new ThreadLocal<>();

	private StepTraceManager() {
	}

	public static void startSession() {

		RECORDER.set(new StepTraceRecorder());
	}

	public static StepTraceRecorder getRecorder() {

		return RECORDER.get();
	}

	public static void clear() {

		RECORDER.remove();
	}
}