package com.qaverse.smart.trace.storage;

import com.qaverse.smart.trace.storage.provider.InMemoryTraceStorageProvider;
import com.qaverse.smart.trace.storage.provider.TraceStorageProvider;

public class DashboardRepository {

	private final TraceStorageProvider storageProvider = new InMemoryTraceStorageProvider();

	public void saveDashboardData(String key, Object value) {

		storageProvider.save(key, value);
	}

	public Object getDashboardData(String key) {

		return storageProvider.get(key);
	}

	public void deleteDashboardData(String key) {

		storageProvider.delete(key);
	}
}