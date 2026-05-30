package com.qaverse.smart.trace.model.failure;

import java.util.ArrayList;
import java.util.List;

public class FailureTimeline {

	private final List<TimelineEvent> events = new ArrayList<>();

	public void addEvent(TimelineEvent event) {

		events.add(event);
	}

	public List<TimelineEvent> getEvents() {

		return events;
	}
}