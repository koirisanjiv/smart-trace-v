package com.qaverse.smart.trace.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventQueue<T> implements TraceQueue<T> {

	private final BlockingQueue<T> queue = new LinkedBlockingQueue<>();

	@Override
	public void push(T item) {

		if (item == null) {
			return;
		}

		queue.offer(item);
	}

	@Override
	public T poll() {

		return queue.poll();
	}

	@Override
	public int size() {

		return queue.size();
	}

	@Override
	public boolean isEmpty() {

		return queue.isEmpty();
	}
}