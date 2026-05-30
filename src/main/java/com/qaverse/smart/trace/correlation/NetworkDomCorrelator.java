package com.qaverse.smart.trace.correlation;

public class NetworkDomCorrelator {

	public String correlate(long apiResponseTime, boolean domUpdated) {

		if (apiResponseTime > 5000 && domUpdated) {

			return "Slow API response triggered DOM refresh";
		}

		if (apiResponseTime > 5000) {

			return "Network latency detected";
		}

		if (domUpdated) {

			return "Unexpected DOM update detected";
		}

		return "No network-dom issue found";
	}
}