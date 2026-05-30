package com.qaverse.smart.trace.storage;

import com.qaverse.smart.trace.storage.provider.InMemoryTraceStorageProvider;
import com.qaverse.smart.trace.storage.provider.TraceStorageProvider;

public class ExecutionRepository {

	private final TraceStorageProvider storageProvider = new InMemoryTraceStorageProvider();

	public void saveExecution(String executionId, Object execution) {

		storageProvider.save(executionId, execution);
	}

	public Object findExecution(String executionId) {

		return storageProvider.get(executionId);
	}

	public boolean exists(String executionId) {

		return storageProvider.exists(executionId);
	}

	public void deleteExecution(String executionId) {

		storageProvider.delete(executionId);
	}
}