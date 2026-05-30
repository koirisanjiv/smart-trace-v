package com.qaverse.smart.trace.correlation;

public class ScreenshotLogCorrelator {

	public String correlate(String screenshotPath, String logs) {

		if (logs == null) {
			return "No log correlation found";
		}

		String lowerLogs = logs.toLowerCase();

		if (lowerLogs.contains("element click intercepted")) {

			return "Popup or overlay detected " + "during screenshot timeline";
		}

		if (lowerLogs.contains("stale")) {

			return "DOM changed before screenshot capture";
		}

		return "No screenshot-log correlation identified";
	}
}