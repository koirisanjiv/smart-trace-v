package com.qaverse.smart.trace.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.qaverse.smart.trace.model.failure.FailureRecord;
import com.qaverse.smart.trace.model.failure.RootCauseRecord;

public class JsonTraceExporter {

	public File export(String fileName, FailureRecord record) {

		File file = new File(fileName);

		File parent = file.getParentFile();

		if (parent != null && !parent.exists()) {

			parent.mkdirs();
		}

		try (FileWriter writer = new FileWriter(file)) {

			writer.write("{\n");

			writer.write("\"failureId\":\"" + sanitize(record.getFailureId()) + "\",\n");

			writer.write("\"traceId\":\"" + sanitize(record.getTraceId()) + "\",\n");

			writer.write("\"timestamp\":\"" + String.valueOf(record.getFailureTime()) + "\",\n");

			writer.write("\"testName\":\"" + sanitize(record.getTestName()) + "\",\n");

			writer.write("\"executionTime\":" + record.getExecutionTime() + ",\n");

			writer.write("\"exceptionType\":\"" + sanitize(record.getExceptionType()) + "\",\n");

			writer.write("\"exceptionMessage\":\"" + sanitize(record.getExceptionMessage()) + "\"");

			RootCauseRecord rootCause = record.getRootCause();

			if (rootCause != null) {

				writer.write(",\n");

				writer.write("\"rootCause\":\"" + sanitize(rootCause.getRootCause()) + "\",\n");

				writer.write("\"severity\":\"" + sanitize(rootCause.getSeverity()) + "\",\n");

				writer.write("\"priority\":\"" + sanitize(rootCause.getPriority()) + "\",\n");

				writer.write("\"confidence\":" + rootCause.getConfidence());
			}

			if (record.getFingerprintId() != null) {

				writer.write(",\n");

				writer.write("\"fingerprintId\":\"" + sanitize(record.getFingerprintId()) + "\"");
			}

			writer.write("\n}");

		} catch (IOException e) {

			throw new RuntimeException("JSON export failed", e);
		}

		System.out.println("[SMART-TRACE] Exported : " + file.getAbsolutePath());

		return file;
	}

	private String sanitize(String value) {

		if (value == null) {

			return "";
		}

		return value.replace("\"", "'").replace("\n", " ").replace("\r", " ");
	}
}