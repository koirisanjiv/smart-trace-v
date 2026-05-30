package com.qaverse.smart.trace.integration.selenium;

public final class SeleniumContext {

	private static WebDriverProvider provider = new DefaultWebDriverProvider();

	private SeleniumContext() {
	}

	public static void setProvider(WebDriverProvider webDriverProvider) {

		provider = webDriverProvider;
	}

	public static WebDriverProvider getProvider() {

		return provider;
	}
}