package com.qaverse.smart.trace.trace.rootcause;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class RootCausePathBuilder {

	public RootCausePath build(FailureRecord record) {

		RootCausePath path = new RootCausePath();

		path.add("Failure");

		path.add(record.getExceptionType());

		if (record.getRootCause() != null) {

			path.add(record.getRootCause().getCategory());

			path.add(record.getRootCause().getRootCause());
		}

		return path;
	}
}