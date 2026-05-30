package com.qaverse.smart.trace.visualization;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimelineRenderer {

	private final List<String> timeline = new ArrayList<>();

	public void addEvent(String event) {

		timeline.add(LocalDateTime.now() + " : " + event);
	}

	public List<String> build() {

		return new ArrayList<>(timeline);
	}

	public void clear() {

		timeline.clear();
	}
}