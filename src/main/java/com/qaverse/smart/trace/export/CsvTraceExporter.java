package com.qaverse.smart.trace.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.qaverse.smart.trace.model.failure.CorrelationRecord;
import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.model.failure.RootCauseRecord;

public class CsvTraceExporter {

	public File export(String fileName, FailureRecord record) {

		File file = new File(fileName);

		try (FileWriter writer = new FileWriter(file)) {


			writer.write("KEY,VALUE\n");

			/*
			 * Failure Details
			 */

			writer.write("FailureId," + nullSafe(record.getFailureId()) + "\n");

			writer.write("TraceId," + nullSafe(record.getTraceId()) + "\n");

			writer.write("TestName," + nullSafe(record.getTestName()) + "\n");

			writer.write("ExceptionType," + nullSafe(record.getExceptionType()) + "\n");

			writer.write("ExceptionMessage," + sanitize(record.getExceptionMessage()) + "\n");

			/*
			 * Root Cause
			 */

			RootCauseRecord rootCause = record.getRootCause();

			if (rootCause != null) {

				writer.write("Category," + sanitize(rootCause.getCategory()) + "\n");

				writer.write("\"rootCause\":\"" + (rootCause == null ? "" : rootCause.getRootCause()) + "\",\n");

				writer.write("\"severity\":\"" + (rootCause == null ? "" : rootCause.getSeverity()) + "\",\n");

				writer.write("\"priority\":\"" + (rootCause == null ? "" : rootCause.getPriority()) + "\",\n");

				writer.write("\"confidence\":" + (rootCause == null ? 0 : rootCause.getConfidence()) + ",\n");
			}

			/*
			 * Correlation
			 */

			CorrelationRecord correlation = record.getCorrelation();

			if (correlation != null) {

				writer.write("CorrelationConfidence," + correlation.getConfidence() + "\n");

				int index = 1;

				for (String evidence : correlation.getEvidence()) {

					writer.write("Evidence-" + index++ + "," + sanitize(evidence) + "\n");
				}
			}

			/*
			 * Recommendations
			 */

			int recommendationIndex = 1;

			for (String recommendation : record.getRecommendations()) {

				writer.write("Recommendation-" + recommendationIndex++ + "," + sanitize(recommendation) + "\n");
			}

		} catch (IOException e) {

			throw new RuntimeException("CSV export failed", e);
		}

		return file;
	}

	private String nullSafe(String value) {

		return value == null ? "" : value;
	}

	private String sanitize(String value) {

		if (value == null) {

			return "";
		}

		return value.replace(",", " ").replace("\n", " ").replace("\r", " ");
	}
}