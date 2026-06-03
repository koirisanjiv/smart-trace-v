package com.qaverse.smart.trace.core;

import com.qaverse.smart.trace.capture.logs.LogCaptureService;
import com.qaverse.smart.trace.classifier.FailureClassificationEngine;
import com.qaverse.smart.trace.core.event.TraceEventBus;
import com.qaverse.smart.trace.dashboard.SmartTraceDashboard;
import com.qaverse.smart.trace.integration.selenium.SeleniumTraceSubscriber;
import com.qaverse.smart.trace.sdk.TraceOptions;

public final class TraceBootstrap {

	private static SmartTraceEngine engine;
	private static TraceOptions options;

	private TraceBootstrap() {
	}

	public static void initialize(TraceOptions traceOptions) {

		TraceEventBus eventBus = new TraceEventBus();

		registerSubscribers(eventBus);

		engine = new SmartTraceEngine(eventBus);

		SmartTraceDashboard.initialize();

		TraceBootstrap.options = traceOptions;

		System.out.println("Smart Trace Engine Initialized");
	}

	private static void registerSubscribers(TraceEventBus eventBus) {

		new LogCaptureService(eventBus);

		new FailureClassificationEngine(eventBus);

		new SeleniumTraceSubscriber(eventBus);
	}

	public static SmartTraceEngine getEngine() {
		return engine;
	}
	
	public static TraceOptions getOptions() {
	    return options;
	}
}