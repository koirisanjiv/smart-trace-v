package com.qaverse.smart.trace.trace.rootcause;

import java.util.ArrayList;
import java.util.List;

public class RootCauseNode {

	private String name;

	private String description;

	private final List<RootCauseNode> children = new ArrayList<>();

	public RootCauseNode() {
	}

	public RootCauseNode(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RootCauseNode> getChildren() {
		return children;
	}

	public void addChild(RootCauseNode node) {
		children.add(node);
	}
}