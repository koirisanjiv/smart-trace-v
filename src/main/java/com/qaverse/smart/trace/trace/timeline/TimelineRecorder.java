package com.qaverse.smart.trace.trace.timeline;

import com.qaverse.smart.trace.model.failure.FailureTimeline;
import com.qaverse.smart.trace.model.failure.TimelineEvent;

public class TimelineRecorder {

	private final FailureTimeline timeline = new FailureTimeline();

	public void record(TimelineEventType type, String message) {

		TimelineEvent event = new TimelineEvent();

		event.setType(type);

		event.setMessage(message);

		timeline.addEvent(event);
	}

	public FailureTimeline getTimeline() {

		return timeline;
	}
}