package com.qaverse.smart.trace.dashboard.html;

import java.util.List;

public class InvestigationTableBuilder {

	public String buildRows(
			List<InvestigationJson> investigations
	) {

		StringBuilder rows =
				new StringBuilder();

		for (InvestigationJson investigation
				: investigations) {

			rows.append("<tr>");

			rows.append("<td>")
					.append(
							nullSafe(
									investigation.getTestName()
							)
					)
					.append("</td>");

			rows.append("<td>")
					.append(
							nullSafe(
									investigation.getRootCause()
							)
					)
					.append("</td>");

			rows.append("<td>")
					.append(
							nullSafe(
									investigation.getSeverity()
							)
					)
					.append("</td>");

			rows.append("<td>")
					.append(
							nullSafe(
									investigation.getPriority()
							)
					)
					.append("</td>");

			rows.append("<td>")
					.append(
							investigation.getConfidence()
					)
					.append("%</td>");

			rows.append("<td>")
					.append(
							shortFingerprint(
									investigation.getFingerprintId()
							)
					)
					.append("</td>");

			rows.append("</tr>");
		}

		return rows.toString();
	}

	private String shortFingerprint(
			String fingerprint
	) {

		if (fingerprint == null) {

			return "";
		}

		if (fingerprint.length() <= 12) {

			return fingerprint;
		}

		return fingerprint.substring(
				0,
				12
		) + "...";
	}

	private String nullSafe(
			String value
	) {

		return value == null
				? ""
				: value;
	}
}