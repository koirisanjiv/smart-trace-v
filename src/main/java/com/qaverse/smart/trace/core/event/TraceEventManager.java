package com.qaverse.smart.trace.core.event;

public class TraceEventManager {

	private static final TraceEventBus EVENT_BUS = new TraceEventBus();

	private TraceEventManager() {
	}

	public static TraceEventBus getEventBus() {

		return EVENT_BUS;
	}

	public static void publish(TraceEvent event) {

		EVENT_BUS.publish(event);
	}
}