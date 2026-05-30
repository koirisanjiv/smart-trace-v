package com.qaverse.smart.trace.export;

import java.io.File;

public class TraceSharingService {

	public String buildSharePath(File file) {

		if (file == null) {

			return "";
		}

		return file.getAbsolutePath();
	}

	public boolean isValid(File file) {

		return file != null && file.exists();
	}
}