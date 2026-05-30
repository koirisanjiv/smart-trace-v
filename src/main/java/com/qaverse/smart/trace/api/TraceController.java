package com.qaverse.smart.trace.api;

import java.util.HashMap;
import java.util.Map;

import com.qaverse.smart.trace.model.trace.TraceSession;
import com.qaverse.smart.trace.model.trace.TraceSessionManager;

public class TraceController {

	private final TraceSessionManager sessionManager = new TraceSessionManager();

	public TraceSession startTrace() {

		return sessionManager.startSession();
	}

	public Map<String, Object> getTrace(String traceId) {

		Map<String, Object> response = new HashMap<>();

		response.put("trace", sessionManager.getSession(traceId));

		return response;
	}
}