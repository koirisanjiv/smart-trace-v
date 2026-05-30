package com.qaverse.smart.trace.visualization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HeatmapBuilder {

	private final Map<String, Integer> heatmap = new ConcurrentHashMap<>();

	public void addFailure(String component) {

		heatmap.merge(component, 1, Integer::sum);
	}

	public Map<String, Integer> build() {

		return heatmap;
	}
}