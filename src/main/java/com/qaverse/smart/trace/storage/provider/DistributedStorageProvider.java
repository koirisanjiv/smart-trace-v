package com.qaverse.smart.trace.storage.provider;

public interface DistributedStorageProvider {

	void connect();

	void disconnect();

	boolean isConnected();
}