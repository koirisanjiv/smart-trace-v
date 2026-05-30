package com.qaverse.smart.trace.correlation;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExceptionTimelineCorrelator {

	public String correlate(LocalDateTime actionTime, LocalDateTime failureTime) {

		long seconds = Duration.between(actionTime, failureTime).getSeconds();

		if (seconds <= 2) {

			return "Immediate failure after action";
		}

		if (seconds <= 10) {

			return "Delayed application response detected";
		}

		return "Long-running instability detected";
	}
}