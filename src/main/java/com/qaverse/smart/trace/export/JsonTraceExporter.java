package com.qaverse.smart.trace.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.qaverse.smart.trace.model.failure.FailureRecord;

public class JsonTraceExporter {

	public File export(String fileName, FailureRecord record) {

		File file = new File(fileName);

		try (FileWriter writer = new FileWriter(file)) {

			writer.write("{\n");

			writer.write("\"failureId\":\"" + record.getFailureId() + "\",\n");

			writer.write("\"traceId\":\"" + record.getTraceId() + "\",\n");

			writer.write("\"testName\":\"" + record.getTestName() + "\",\n");

			writer.write("\"exceptionType\":\"" + record.getExceptionType() + "\",\n");

			writer.write("\"exceptionMessage\":\"" + String.valueOf(record.getExceptionMessage()) + "\"\n");

			writer.write("}");

		} catch (IOException e) {

			throw new RuntimeException("JSON export failed", e);
		}

		return file;
	}
}