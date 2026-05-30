package com.qaverse.smart.trace.export;

import java.io.File;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class TraceExportManager {

	private final JsonTraceExporter jsonExporter = new JsonTraceExporter();

	private final CsvTraceExporter csvExporter = new CsvTraceExporter();

	public File export(ExportFormat format, String fileName, FailureRecord record) {

		switch (format) {

		case JSON:

			return jsonExporter.export(fileName, record);

		case CSV:

			return csvExporter.export(fileName, record);

		default:

			throw new IllegalArgumentException("Unsupported export format");
		}
	}
}