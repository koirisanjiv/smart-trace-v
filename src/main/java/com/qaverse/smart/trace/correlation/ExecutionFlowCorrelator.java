package com.qaverse.smart.trace.correlation;

import java.util.List;

public class ExecutionFlowCorrelator {

	public String correlate(List<String> executionSteps) {

		if (executionSteps == null || executionSteps.isEmpty()) {

			return "No execution flow found";
		}

		int lastIndex = executionSteps.size() - 1;

		return "Failure occurred after step : " + executionSteps.get(lastIndex);
	}
}