package com.qaverse.smart.trace.capture.environment;

public class EnvironmentCaptureService {

	public EnvironmentInfo capture() {

		EnvironmentInfo info = new EnvironmentInfo();

		info.setOsName(System.getProperty("os.name"));

		info.setJavaVersion(System.getProperty("java.version"));

		info.setUserName(System.getProperty("user.name"));

		return info;
	}
}