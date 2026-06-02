package com.qaverse.smart.trace.dashboard.html;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmartTraceDashboardGenerator {

	private final InvestigationJsonReader reader = new InvestigationJsonReader();

	private final RootCauseAggregator rootCauseAggregator = new RootCauseAggregator();

	private final FingerprintAggregator fingerprintAggregator = new FingerprintAggregator();
	
	private final InvestigationTableBuilder investigationTableBuilder = new InvestigationTableBuilder();
	
	private final TopFailingTestsAggregator topFailingTestsAggregator = new TopFailingTestsAggregator();
	
	private final TimelineAggregator timelineAggregator = new TimelineAggregator();

	public void generate() {

		try {
			
			List<InvestigationJson> investigations = reader.readAll();

			InputStream stream = getClass().getClassLoader()
					.getResourceAsStream("templates/smart-trace-dashboard.html");

			String html = new String(stream.readAllBytes());

			html = html.replace("{{TOTAL_FAILURES}}", String.valueOf(investigations.size()));

			html = html.replace("{{CRITICAL_FAILURES}}", String.valueOf(criticalFailures(investigations)));

			html = html.replace("{{UNIQUE_FINGERPRINTS}}", String.valueOf(uniqueFingerprints(investigations)));

			html = html.replace("{{RECURRING_FAILURES}}", String.valueOf(recurringFailures(investigations)));

			html = html.replace("{{ROOT_CAUSE_ROWS}}", rootCauseAggregator.buildRows(investigations));

			html = html.replace("{{FINGERPRINT_ROWS}}", fingerprintAggregator.buildRows(investigations));
			
			html = html.replace("{{INVESTIGATION_ROWS}}", investigationTableBuilder.buildRows(investigations));
			
			html = html.replace("{{TOP_TEST_ROWS}}", topFailingTestsAggregator.buildRows(investigations));
			
			html = html.replace("{{TIMELINE_ROWS}}", timelineAggregator.buildRows(investigations));
			
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