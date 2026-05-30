package com.qaverse.smart.trace.capture.page;

import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.WebDriver;

public class PageSourceCaptureService {

	public PageSourceCaptureResult capture(WebDriver driver, String fileName) {

		PageSourceCaptureResult result = new PageSourceCaptureResult();

		try {

			String pageSource = driver.getPageSource();

			File file = new File(fileName);

			file.getParentFile().mkdirs();

			try (FileWriter writer = new FileWriter(file)) {

				writer.write(pageSource);
			}

			result.setSuccess(true);
			result.setFilePath(file.getAbsolutePath());

		} catch (Exception e) {

			result.setSuccess(false);
		}

		return result;
	}
}