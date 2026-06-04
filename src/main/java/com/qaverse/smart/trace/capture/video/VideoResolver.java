package com.qaverse.smart.trace.capture.video;

import java.io.File;

public class VideoResolver {

    public String findVideo(
            String projectName,
            String testName
    ) {

        File folder =
                new File(
                        "Reports/"
                        + projectName
                        + "/videos"
                );

        if (!folder.exists()) {

            return null;
        }

        File[] files = folder.listFiles();

        if (files == null) {

            return null;
        }

        for (File file : files) {

            if (file.isFile()) {

                return "videos/"
                        + file.getName();
            }
        }

        return null;
    }
}