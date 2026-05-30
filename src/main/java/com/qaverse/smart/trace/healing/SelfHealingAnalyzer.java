package com.qaverse.smart.trace.healing;

public class SelfHealingAnalyzer {

	private final LocatorHealingEngine locatorHealingEngine = new LocatorHealingEngine();

	private final DynamicWaitHealingEngine dynamicWaitHealingEngine = new DynamicWaitHealingEngine();

	private final SmartRetryEngine smartRetryEngine = new SmartRetryEngine();

	public void analyze(String locator, Throwable throwable) {

		System.out.println("=== SELF HEALING ANALYSIS ===");

		System.out.println("Alternative Locators : " + locatorHealingEngine.generateAlternativeLocators(locator));

		System.out.println("Recommended Wait Time : " + dynamicWaitHealingEngine.recommendWaitTime(throwable));

		System.out.println("Retry Recommended : " + smartRetryEngine.shouldRetry(throwable));
	}
}