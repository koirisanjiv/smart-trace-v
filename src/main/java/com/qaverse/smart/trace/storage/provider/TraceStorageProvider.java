package com.qaverse.smart.trace.storage.provider;

public interface TraceStorageProvider {

	void save(String key, Object value);

	Object get(String key);

	boolean exists(String key);

	void delete(String key);
}