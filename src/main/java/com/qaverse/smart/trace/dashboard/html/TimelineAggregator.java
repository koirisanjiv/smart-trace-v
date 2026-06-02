package com.qaverse.smart.trace.dashboard.html;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimelineAggregator {

	public String buildRows(
			List<InvestigationJson> investigations
	) {

		Map<LocalDate, Integer> counts =
				new TreeMap<>();

		for (InvestigationJson investigation
				: investigations) {

			try {

				String timestamp =
						investigation.getTimestamp();

				if (timestamp == null
						|| timestamp.isBlank()) {

					continue;
				}

				LocalDate date =
						LocalDateTime
								.parse(timestamp)
								.toLocalDate();

				counts.merge(
						date,
						1,
						Integer::sum
				);

			} catch (Exception e) {

				// ignore malformed dates
			}
		}

		StringBuilder rows =
				new StringBuilder();

		for (Map.Entry<LocalDate, Integer> entry
				: counts.entrySet()) {

			rows.append("<tr>");

			rows.append("<td>")
					.append(entry.getKey()).
					append("</td>");

			rows.append("<td>")
					.append(entry.getValue())
					.append("</td>");

			rows.append("</tr>");
		}

		return rows.toString();
	}
}