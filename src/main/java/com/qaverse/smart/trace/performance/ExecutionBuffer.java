package com.qaverse.smart.trace.performance;

import java.util.ArrayList;
import java.util.List;

public class ExecutionBuffer<T> {

	private final List<T> buffer = new ArrayList<>();

	private final int maxSize;

	public ExecutionBuffer(int maxSize) {

		this.maxSize = maxSize;
	}

	public synchronized void add(T value) {

		if (buffer.size() >= maxSize) {

			buffer.remove(0);
		}

		buffer.add(value);
	}

	public synchronized List<T> getAll() {

		return new ArrayList<>(buffer);
	}

	public synchronized void clear() {

		buffer.clear();
	}

	public synchronized int size() {

		return buffer.size();
	}
}