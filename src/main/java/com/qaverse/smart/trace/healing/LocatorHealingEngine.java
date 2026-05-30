package com.qaverse.smart.trace.healing;

import java.util.ArrayList;
import java.util.List;

public class LocatorHealingEngine {

	public List<String> generateAlternativeLocators(String locator) {

		List<String> alternatives = new ArrayList<>();

		if (locator == null || locator.isEmpty()) {

			return alternatives;
		}

		if (locator.contains("//div[")) {

			alternatives.add(locator.replace("//div[", "//*[@"));
		}

		if (locator.contains("text()")) {

			alternatives.add(locator.replace("text()", "@value"));
		}

		if (locator.contains("contains")) {

			alternatives.add("Use exact attribute match");
		}

		alternatives.add("Use data-testid locator strategy");

		return alternatives;
	}
}