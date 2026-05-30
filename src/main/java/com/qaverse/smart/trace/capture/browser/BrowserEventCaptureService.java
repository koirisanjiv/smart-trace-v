package com.qaverse.smart.trace.capture.browser;

import java.util.ArrayList;
import java.util.List;

public class BrowserEventCaptureService {

	private final List<BrowserEvent> events = new ArrayList<>();

	public void record(String action) {

		events.add(new BrowserEvent(action));
	}

	public List<BrowserEvent> getEvents() {

		return new ArrayList<>(events);
	}

	public void clear() {

		events.clear();
	}
}