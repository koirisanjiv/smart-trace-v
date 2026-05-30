package com.qaverse.smart.trace.core.event;

@FunctionalInterface
public interface TraceEventSubscriber {

	void onEvent(TraceEvent event);
}