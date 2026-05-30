package com.qaverse.smart.trace.sdk;

import com.qaverse.smart.trace.core.TraceBootstrap;

public final class Trace {

	private Trace() {
	}

	public static void enable() {
		TraceBootstrap.initialize(new TraceOptions());
	}

	public static void enable(TraceOptions options) {
		TraceBootstrap.initialize(options);
	}
}