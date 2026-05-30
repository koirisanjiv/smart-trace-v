package com.qaverse.smart.trace.model.trace;

public class SessionLifecycleManager {

	private final TraceSessionManager sessionManager = new TraceSessionManager();

	public TraceSession start() {

		return sessionManager.startSession();
	}

	public void pass(String sessionId) {

		sessionManager.closeSession(sessionId, "PASSED");
	}

	public void fail(String sessionId) {

		sessionManager.closeSession(sessionId, "FAILED");
	}
}