package com.qaverse.smart.trace.integration.selenium;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface WebDriverProvider {

	WebDriver getDriver();
}