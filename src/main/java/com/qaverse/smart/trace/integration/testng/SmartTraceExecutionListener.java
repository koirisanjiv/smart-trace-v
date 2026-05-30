package com.qaverse.smart.trace.integration.testng;

import org.testng.IExecutionListener;

public class SmartTraceExecutionListener implements IExecutionListener {

	@Override
	public void onExecutionStart() {

		System.out.println("[SMART-TRACE] Execution Started");
	}

	@Override
	public void onExecutionFinish() {

		System.out.println("[SMART-TRACE] Execution Finished");
	}
}