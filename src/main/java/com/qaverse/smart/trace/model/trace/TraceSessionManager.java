package com.qaverse.smart.trace.model.trace;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TraceSessionManager {

	private final Map<String, TraceSession> sessions = new ConcurrentHashMap<>();

	public TraceSession startSession() {

		TraceSession session = new TraceSession();

		sessions.put(session.getSessionId(), session);

		return session;
	}

	public TraceSession getSession(String sessionId) {

		return sessions.get(sessionId);
	}

	public void closeSession(String sessionId, String status) {

		TraceSession session = sessions.get(sessionId);

		if (session != null) {

			session.finish(status);
		}
	}
}