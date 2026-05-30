package com.qaverse.smart.trace.storage;

import com.qaverse.smart.trace.storage.provider.InMemoryTraceStorageProvider;
import com.qaverse.smart.trace.storage.provider.TraceStorageProvider;

public class TraceRepository {

	private final TraceStorageProvider storageProvider = new InMemoryTraceStorageProvider();

	public void save(String traceId, Object value) {

		storageProvider.save(traceId, value);
	}

	public Object find(String traceId) {

		return storageProvider.get(traceId);
	}

	public boolean exists(String traceId) {

		return storageProvider.exists(traceId);
	}

	public void delete(String traceId) {

		storageProvider.delete(traceId);
	}
}