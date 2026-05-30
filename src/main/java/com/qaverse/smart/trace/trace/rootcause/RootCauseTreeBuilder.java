package com.qaverse.smart.trace.trace.rootcause;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class RootCauseTreeBuilder {

	public RootCauseTree build(FailureRecord record) {

		RootCauseTree tree = new RootCauseTree();

		RootCauseNode failure = new RootCauseNode("Failure");

		RootCauseNode exception = new RootCauseNode(record.getExceptionType());

		failure.addChild(exception);

		if (record.getRootCause() != null) {

			RootCauseNode rootCause = new RootCauseNode(record.getRootCause().getRootCause());

			exception.addChild(rootCause);

			RootCauseNode category = new RootCauseNode(record.getRootCause().getCategory());

			rootCause.addChild(category);
		}

		tree.setRoot(failure);

		return tree;
	}
}