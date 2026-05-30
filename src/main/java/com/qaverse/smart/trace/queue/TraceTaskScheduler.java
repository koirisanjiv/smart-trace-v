package com.qaverse.smart.trace.queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TraceTaskScheduler {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

	public void schedule(Runnable runnable, long delaySeconds) {

		if (runnable == null) {
			return;
		}

		scheduler.schedule(runnable, delaySeconds, TimeUnit.SECONDS);
	}

	public void shutdown() {

		scheduler.shutdown();
	}
}