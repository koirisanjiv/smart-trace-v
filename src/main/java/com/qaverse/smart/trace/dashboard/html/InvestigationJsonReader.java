package com.qaverse.smart.trace.dashboard.html;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class InvestigationJsonReader {

	private static final String TRACE_FOLDER = "smart-trace";

	public List<InvestigationJson> readAll() {

		List<InvestigationJson> investigations = new ArrayList<>();

		File folder = new File(TRACE_FOLDER);

		if (!folder.exists()) {

			return investigations;
		}

		File[] files = folder.listFiles((file, name) -> name.endsWith(".json"));

		if (files == null) {

			return investigations;
		}

		for (File file : files) {

			try {

				String json = Files.readString(file.toPath());

				InvestigationJson record = parse(json);

				investigations.add(record);

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return investigations;
	}

	private InvestigationJson parse(String json) {

		InvestigationJson record = new InvestigationJson();

		record.setFailureId(value(json, "failureId"));

		record.setTraceId(value(json, "traceId"));

		record.setTimestamp(value(json, "timestamp"));

		record.setTestName(value(json, "testName"));

		record.setExceptionType(value(json, "exceptionType"));

		record.setRootCause(value(json, "rootCause"));

		record.setSeverity(value(json, "severity"));

		record.setPriority(value(json, "priority"));

		record.setFingerprintId(value(json, "fingerprintId"));

		return record;
	}

	private String value(String json, String key) {

		String token = "\"" + key + "\":\"";

		int start = json.indexOf(token);

		if (start == -1) {

			return "";
		}

		start += token.length();

		int end = json.indexOf("\"", start);

		return json.substring(start, end);
	}
}