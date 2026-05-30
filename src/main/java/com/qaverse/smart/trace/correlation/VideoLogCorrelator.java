package com.qaverse.smart.trace.correlation;

public class VideoLogCorrelator {

	public String correlate(String videoTimestamp, String logs) {

		if (logs == null) {
			return "No video-log correlation found";
		}

		if (logs.toLowerCase().contains("timeout")) {

			return "Application freeze detected " + "near video timestamp : " + videoTimestamp;
		}

		return "No video-log correlation identified";
	}
}