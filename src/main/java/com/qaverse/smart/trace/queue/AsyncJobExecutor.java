package com.qaverse.smart.trace.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncJobExecutor {

	private final ExecutorService executorService = Executors.newFixedThreadPool(4);

	public void execute(Runnable runnable) {

		if (runnable == null) {
			return;
		}

		executorService.submit(runnable);
	}

	public void shutdown() {

		executorService.shutdown();
	}
}