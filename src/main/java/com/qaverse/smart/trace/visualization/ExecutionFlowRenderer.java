package com.qaverse.smart.trace.visualization;

import java.util.ArrayList;
import java.util.List;

public class ExecutionFlowRenderer {

	private final List<String> steps = new ArrayList<>();

	public void addStep(String step) {

		steps.add(step);
	}

	public List<String> render() {

		return new ArrayList<>(steps);
	}

	public void clear() {

		steps.clear();
	}
}