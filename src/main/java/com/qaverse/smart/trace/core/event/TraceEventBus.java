package com.qaverse.smart.trace.core.event;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TraceEventBus implements TraceEventPublisher {

	private final Map<TraceEventType, List<TraceEventSubscriber>> subscribers = new ConcurrentHashMap<>();

	private final ExecutorService executor = Executors.newFixedThreadPool(4);

	public TraceEventBus() {

		for (TraceEventType type : TraceEventType.values()) {

			subscribers.put(type, new CopyOnWriteArrayList<>());
		}
	}

	public void subscribe(TraceEventType type, TraceEventSubscriber subscriber) {

		subscribers.get(type).add(subscriber);
	}

	@Override
	public void publish(TraceEvent event) {

		List<TraceEventSubscriber> listeners = subscribers.get(event.getType());

		if (listeners == null) {
			return;
		}

		for (TraceEventSubscriber listener : listeners) {

			executor.submit(() -> {

				try {

					listener.onEvent(event);

				} catch (Exception e) {

					System.err.println("Event Processing Failed : " + e.getMessage());
				}
			});
		}
	}

	public void shutdown() {

		executor.shutdown();
	}
}