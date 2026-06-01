package com.qaverse.smart.trace.debug;

import com.qaverse.smart.trace.trace.investigation.InvestigationRecord;

public class LocalInvestigationPrinter {

	public void print(InvestigationRecord record) {

		System.out.println();
		System.out.println("========== SMART TRACE ==========");

		System.out.println("Failure Id : " + record.getFailure().getFailureId());

		System.out.println("Test : " + record.getFailure().getTestName());

		if (record.getSummary() != null) {

			System.out.println("Root Cause : " + record.getSummary().getRootCause());

			System.out.println("Confidence : " + record.getSummary().getConfidence());

			System.out.println("Severity : " + record.getSummary().getSeverity());

			System.out.println("Priority : " + record.getSummary().getPriority());
		}

		System.out.println("=================================");
	}
}