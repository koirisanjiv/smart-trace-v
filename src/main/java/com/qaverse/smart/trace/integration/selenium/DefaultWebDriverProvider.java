package com.qaverse.smart.trace.integration.selenium;

import org.openqa.selenium.WebDriver;

public class DefaultWebDriverProvider implements WebDriverProvider {

	private static WebDriver driver;

	public static void register(WebDriver webDriver) {

		driver = webDriver;
	}

	@Override
	public WebDriver getDriver() {

		return driver;
	}
}