package com.qaverse.smart.trace.capture.screenshots;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCaptureService {

	public ScreenshotCaptureResult capture(WebDriver driver, String fileName) {

		ScreenshotCaptureResult result = new ScreenshotCaptureResult();

		try {

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destination = new File(fileName);

			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

			result.setSuccess(true);

			result.setScreenshotPath(destination.getAbsolutePath());

		} catch (Exception e) {

			result.setSuccess(false);
		}

		return result;
	}
}