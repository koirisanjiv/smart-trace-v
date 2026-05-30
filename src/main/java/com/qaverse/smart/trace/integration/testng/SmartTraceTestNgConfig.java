package com.qaverse.smart.trace.integration.testng;

public final class SmartTraceTestNgConfig {

	private SmartTraceTestNgConfig() {
	}

	public static String[] listeners() {

		return new String[] {

				SmartTraceTestListener.class.getName(),

				SmartTraceSuiteListener.class.getName(),

				SmartTraceExecutionListener.class.getName() };
	}
}