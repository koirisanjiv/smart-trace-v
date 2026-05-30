package com.qaverse.smart.trace.trace.rootcause;

import java.util.ArrayList;
import java.util.List;

public class RootCausePath {

	private final List<String> path = new ArrayList<>();

	public List<String> getPath() {
		return path;
	}

	public void add(String value) {
		path.add(value);
	}

	@Override
	public String toString() {

		return String.join(" -> ", path);
	}
}