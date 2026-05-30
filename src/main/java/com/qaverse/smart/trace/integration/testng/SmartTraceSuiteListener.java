package com.qaverse.smart.trace.integration.testng;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SmartTraceSuiteListener implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {

		System.out.println("[SMART-TRACE] Suite Started : " + suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("[SMART-TRACE] Suite Finished : " + suite.getName());
	}
}