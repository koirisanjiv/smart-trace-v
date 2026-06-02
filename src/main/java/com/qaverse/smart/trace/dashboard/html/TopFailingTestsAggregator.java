package com.qaverse.smart.trace.dashboard.html;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopFailingTestsAggregator {

	public String buildRows(
			List<InvestigationJson> investigations
	) {

		Map<String, Integer> counts =
				new HashMap<>();

		for (InvestigationJson investigation
				: investigations) {

			String testName =
					investigation.getTestName();

			if (testName == null
					|| testName.isBlank()) {

				testName = "Unknown";
			}

			counts.merge(
					testName,
					1,
					Integer::sum
			);
		}

		StringBuilder rows =
				new StringBuilder();

		for (Map.Entry<String, Integer> entry
				: counts.entrySet()) {

			rows.append("<tr>");

			rows.append("<td>")
					.append(entry.getKey())
					.append("</td>");

			rows.append("<td>")
					.append(entry.getValue())
					.append("</td>");

			rows.append("</tr>");
		}

		return rows.toString();
	}
}