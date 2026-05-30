package com.qaverse.smart.trace.core;

import java.util.UUID;

public final class TraceContextManager {

	private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

	private TraceContextManager() {
	}

	public static void start() {
		TRACE_ID.set(UUID.randomUUID().toString());
	}

	public static String getTraceId() {
		return TRACE_ID.get();
	}

	public static void clear() {
		TRACE_ID.remove();
	}
}