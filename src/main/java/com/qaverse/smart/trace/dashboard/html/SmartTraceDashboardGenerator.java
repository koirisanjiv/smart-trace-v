package com.qaverse.smart.trace.dashboard.html;

import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmartTraceDashboardGenerator {

	private final InvestigationJsonReader reader = new InvestigationJsonReader();

	private final RootCauseAggregator rootCauseAggregator = new RootCauseAggregator();

	private final FingerprintAggregator fingerprintAggregator = new FingerprintAggregator();

	public void generate() {

		try {

			List<InvestigationJson> investigations = reader.readAll();

			// String html = Files.readString(new
			// File("templates/smart-trace-dashboard.html").toPath());

			String html = """
					<!DOCTYPE html>
					<html>
					<head>
					    <title>Smart Trace Dashboard</title>
					</head>
					<body>

					<h1>Smart Trace Dashboard</h1>

					<h2>Overview</h2>

					<p>Total Failures: {{TOTAL_FAILURES}}</p>
					<p>Critical Failures: {{CRITICAL_FAILURES}}</p>
					<p>Unique Fingerprints: {{UNIQUE_FINGERPRINTS}}</p>
					<p>Recurring Failures: {{RECURRING_FAILURES}}</p>

					<h2>Root Causes</h2>

					<table border='1'>
					<tr>
					<th>Root Cause</th>
					<th>Count</th>
					</tr>

					{{ROOT_CAUSE_ROWS}}

					</table>

					<h2>Fingerprints</h2>

					<table border='1'>
					<tr>
					<th>Fingerprint</th>
					<th>Occurrences</th>
					<th>Severity</th>
					</tr>

					{{FINGERPRINT_ROWS}}

					</table>

					</body>
					</html>
					""";

			html = html.replace("{{TOTAL_FAILURES}}", String.valueOf(investigations.size()));

			html = html.replace("{{CRITICAL_FAILURES}}", String.valueOf(criticalFailures(investigations)));

			html = html.replace("{{UNIQUE_FINGERPRINTS}}", String.valueOf(uniqueFingerprints(investigations)));

			html = html.replace("{{RECURRING_FAILURES}}", String.valueOf(recurringFailures(investigations)));

			html = html.replace("{{ROOT_CAUSE_ROWS}}", rootCauseAggregator.buildRows(investigations));

			html = html.replace("{{FINGERPRINT_ROWS}}", fingerprintAggregator.buildRows(investigations));

			File output = new File("smart-trace/smart-trace-dashboard.html");

			output.getParentFile().mkdirs();

			Files.writeString(output.toPath(), html);

			System.out.println("[SMART-TRACE] Dashboard Generated : " + output.getAbsolutePath());

		} catch (Exception e) {

			throw new RuntimeException("Failed to generate Smart Trace Dashboard", e);
		}
	}

	private long criticalFailures(List<InvestigationJson> investigations) {

		return investigations.stream()

				.filter(i -> "CRITICAL".equalsIgnoreCase(i.getSeverity()))

				.count();
	}

	private int uniqueFingerprints(List<InvestigationJson> investigations) {

		Set<String> fingerprints = new HashSet<>();

		for (InvestigationJson investigation : investigations) {

			fingerprints.add(investigation.getFingerprintId());
		}

		return fingerprints.size();
	}

	private int recurringFailures(List<InvestigationJson> investigations) {

		return Math.max(0, investigations.size() - uniqueFingerprints(investigations));
	}
}