package com.qaverse.smart.trace.visualization;

import java.util.ArrayList;
import java.util.List;

public class FailureGraphBuilder {

	private final List<String> nodes = new ArrayList<>();

	public void addNode(String node) {

		nodes.add(node);
	}

	public List<String> getNodes() {

		return new ArrayList<>(nodes);
	}

	public void clear() {

		nodes.clear();
	}
}