package com.qaverse.smart.trace.queue;

public interface TraceQueue<T> {

	void push(T item);

	T poll();

	int size();

	boolean isEmpty();
}