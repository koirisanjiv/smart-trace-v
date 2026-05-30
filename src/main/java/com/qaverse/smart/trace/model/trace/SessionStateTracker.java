package com.qaverse.smart.trace.model.trace;

public class SessionStateTracker {

	public boolean isRunning(TraceSession session) {

		return session != null && "RUNNING".equals(session.getStatus());
	}

	public boolean isCompleted(TraceSession session) {

		return session != null && "PASSED".equals(session.getStatus());
	}

	public boolean isFailed(TraceSession session) {

		return session != null && "FAILED".equals(session.getStatus());
	}
}