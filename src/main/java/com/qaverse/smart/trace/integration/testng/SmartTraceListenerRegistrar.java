package com.qaverse.smart.trace.integration.testng;

import org.testng.TestNG;

public final class SmartTraceListenerRegistrar {

	private SmartTraceListenerRegistrar() {
	}

	public static void register(TestNG testNG) {

		testNG.addListener(new SmartTraceTestListener());

		testNG.addListener(new SmartTraceSuiteListener());

		testNG.addListener(new SmartTraceExecutionListener());
	}
}