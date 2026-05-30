package com.qaverse.smart.trace.trace.step;

import java.util.ArrayList;
import java.util.List;

import com.qaverse.smart.trace.model.failure.StepTrace;

public class StepTraceSession {

	private final List<StepTrace> steps = new ArrayList<>();

	public void addStep(StepTrace step) {

		steps.add(step);
	}

	public List<StepTrace> getSteps() {

		return steps;
	}
}