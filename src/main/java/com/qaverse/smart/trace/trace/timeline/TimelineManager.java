package com.qaverse.smart.trace.trace.timeline;

public final class TimelineManager {

	private static final ThreadLocal<TimelineRecorder> RECORDER = new ThreadLocal<>();

	private TimelineManager() {
	}

	public static void start() {

		RECORDER.set(new TimelineRecorder());
	}

	public static TimelineRecorder get() {

		return RECORDER.get();
	}

	public static void clear() {

		RECORDER.remove();
	}
}