package com.qaverse.smart.trace.dashboard.html;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FingerprintAggregator {

	public String buildRows(List<InvestigationJson> investigations) {

		Map<String, Integer> counts = new HashMap<>();

		Map<String, String> severities = new HashMap<>();

		for (InvestigationJson investigation : investigations) {

			String fingerprint = investigation.getFingerprintId();

			if (fingerprint == null || fingerprint.isBlank()) {

				continue;
			}

			counts.merge(fingerprint, 1, Integer::sum);

			severities.putIfAbsent(fingerprint, investigation.getSeverity());
		}

		StringBuilder rows = new StringBuilder();

		for (Map.Entry<String, Integer> entry : counts.entrySet()) {

			rows.append("<tr>");

			rows.append("<td>").append(shortFingerprint(entry.getKey())).append("</td>");

			rows.append("<td>").append(entry.getValue()).append("</td>");

			rows.append("<td>").append(severities.get(entry.getKey())).append("</td>");

			rows.append("</tr>");
		}

		return rows.toString();
	}

	private String shortFingerprint(String fingerprint) {

		if (fingerprint.length() <= 12) {

			return fingerprint;
		}

		return fingerprint.substring(0, 12) + "...";
	}
}