package com.qaverse.smart.trace.trace.step;

import java.time.LocalDateTime;
import java.util.UUID;

import com.qaverse.smart.trace.model.failure.StepStatus;
import com.qaverse.smart.trace.model.failure.StepTrace;

public class StepTraceRecorder {

	private final StepTraceSession session = new StepTraceSession();

	public StepTrace startStep(String stepName) {

		StepTrace step = new StepTrace();

		step.setStepId(UUID.randomUUID().toString());

		step.setStepName(stepName);

		step.setStatus(StepStatus.RUNNING);

		step.setStartTime(LocalDateTime.now());

		session.addStep(step);

		return step;
	}

	public void passStep(StepTrace step) {

		step.setStatus(StepStatus.PASSED);

		step.setEndTime(LocalDateTime.now());
	}

	public void failStep(StepTrace step, Throwable throwable) {

		step.setStatus(StepStatus.FAILED);

		step.setEndTime(LocalDateTime.now());

		if (throwable != null) {

			step.setFailureReason(throwable.getMessage());
		}
	}

	public StepTraceSession getSession() {

		return session;
		}
	}