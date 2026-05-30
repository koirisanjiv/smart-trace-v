package com.qaverse.smart.trace.trace.rootcause;

public class RootCauseVisualizer {

	public void print(RootCauseNode node) {

		print(node, 0);
	}

	private void print(RootCauseNode node, int level) {

		if (node == null) {
			return;
		}

		StringBuilder prefix = new StringBuilder();

		for (int i = 0; i < level; i++) {

			prefix.append("   ");
		}

		System.out.println(prefix + node.getName());

		for (RootCauseNode child : node.getChildren()) {

			print(child, level + 1);
		}
	}
}