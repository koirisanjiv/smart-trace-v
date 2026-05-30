package com.qaverse.smart.trace.trace.timeline;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.model.failure.FailureTimeline;
import com.qaverse.smart.trace.model.failure.StepTrace;
import com.qaverse.smart.trace.model.failure.TimelineEvent;

public class FailureTimelineBuilder {

	public FailureTimeline build(FailureRecord failureRecord) {

		FailureTimeline timeline = new FailureTimeline();

		TimelineEvent start = new TimelineEvent();

		start.setType(TimelineEventType.TEST_STARTED);

		start.setMessage(failureRecord.getTestName());

		timeline.addEvent(start);

		if (failureRecord.getStepTraces() != null) {

			for (StepTrace step : failureRecord.getStepTraces()) {

				TimelineEvent event = new TimelineEvent();

				event.setType(step.getStatus().name().contains("FAIL") ? TimelineEventType.STEP_FAILED
						: TimelineEventType.STEP_PASSED);

				event.setMessage(step.getStepName());

				timeline.addEvent(event);
			}
		}

		if (failureRecord.getRootCause() != null) {

			TimelineEvent root = new TimelineEvent();

			root.setType(TimelineEventType.ROOT_CAUSE_IDENTIFIED);

			root.setMessage(failureRecord.getRootCause().getRootCause());

			timeline.addEvent(root);
		}

		return timeline;
	}
}