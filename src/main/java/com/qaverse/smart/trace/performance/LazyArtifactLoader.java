package com.qaverse.smart.trace.performance;

import java.util.function.Supplier;

public class LazyArtifactLoader<T> {

	private T value;

	private boolean loaded;

	public synchronized T load(Supplier<T> supplier) {

		if (!loaded) {

			value = supplier.get();

			loaded = true;
		}

		return value;
	}

	public boolean isLoaded() {

		return loaded;
	}

	public void clear() {

		value = null;

		loaded = false;
	}
}