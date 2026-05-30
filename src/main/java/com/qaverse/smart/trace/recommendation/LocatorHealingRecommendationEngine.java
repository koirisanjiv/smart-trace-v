package com.qaverse.smart.trace.recommendation;

public class LocatorHealingRecommendationEngine {

	public String recommend(
            String locator
    ) {

        if (locator == null ||
                locator.isEmpty()) {

            return "No locator available";
        }

		if (locator.contains("//div[")) {

            return "Avoid index-based xpath locator";
        }

		if (locator.contains("text()")) {

			return "Avoid text-based unstable locator";
		}

		if (locator.contains("contains")) {

			return "Use unique element identifier";
		}

		return "Locator strategy looks stable";
	}
}