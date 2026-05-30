package com.qaverse.smart.trace.recommendation;

public class FixRecommendationEngine {

	public String recommend(String category) {

		if (category == null) {
			return "Manual investigation required";
		}

		switch (category) {

		case "TIMING_FAILURE":

			return "Use explicit wait " + "before interacting with element";

		case "LOCATOR_FAILURE":

			return "Use stable locator strategy " + "with unique attributes";

		case "DOM_FAILURE":

			return "Wait for DOM stabilization " + "before performing actions";

		case "NETWORK_FAILURE":

			return "Validate environment and API " + "availability before execution";

		case "ASSERTION_FAILURE":

			return "Verify expected business data " + "and assertion logic";

		default:

			return "Review execution logs " + "for detailed investigation";
		}
	}
}