package com.qaverse.smart.trace.performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncTraceProcessor {

	private final ExecutorService executorService = Executors.newFixedThreadPool(4);

	public void process(Runnable runnable) {

		if (runnable == null) {
			return;
		}

		executorService.submit(runnable);
	}

	public void shutdown() {

		executorService.shutdown();
	}
}