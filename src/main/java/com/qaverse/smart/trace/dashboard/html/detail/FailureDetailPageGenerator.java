package com.qaverse.smart.trace.dashboard.html.detail;

import java.io.File;
import java.nio.file.Files;

import com.qaverse.smart.trace.dashboard.html.InvestigationJson;

public class FailureDetailPageGenerator {

	public void generate(String projectName, InvestigationJson investigation) {

		try {


			String html = """
					<!DOCTYPE html>
					<html>
					<head>

					    <title>Failure Details</title>

					    <link rel="stylesheet"
					          href="../../../static/dashboard.css">

					</head>

					<body>

					<div class="card">

					    <h2>Failure Details</h2>

					    <table>

					        <tr>
					            <th>Field</th>
					            <th>Value</th>
					        </tr>

					        <tr>
					            <td>Failure Id</td>
					            <td>{{FAILURE_ID}}</td>
					        </tr>

					        <tr>
					            <td>Trace Id</td>
					            <td>{{TRACE_ID}}</td>
					        </tr>

					        <tr>
					            <td>Timestamp</td>
					            <td>{{TIMESTAMP}}</td>
					        </tr>

					        <tr>
					            <td>Test Name</td>
					            <td>{{TEST_NAME}}</td>
					        </tr>

					        <tr>
					            <td>Exception Type</td>
					            <td>{{EXCEPTION_TYPE}}</td>
					        </tr>

					        <tr>
					            <td>Root Cause</td>
					            <td>{{ROOT_CAUSE}}</td>
					        </tr>

					        <tr>
					            <td>Severity</td>
					            <td>{{SEVERITY}}</td>
					        </tr>

					        <tr>
					            <td>Priority</td>
					            <td>{{PRIORITY}}</td>
					        </tr>

					        <tr>
					            <td>Confidence</td>
					            <td>{{CONFIDENCE}}</td>
					        </tr>

					        <tr>
					            <td>Fingerprint</td>
					            <td>{{FINGERPRINT}}</td>
					        </tr>
					        
					        <tr>

							    <td>Screenshot</td>
		
							    <td>
							        {{SCREENSHOT_LINK}}
							    </td>
			
							</tr>
		
							<tr>
	
							    <td>Video</td>
		
							    <td>
							        {{VIDEO_LINK}}
							    </td>
	
							</tr>

					    </table>

					    <br>

					   <h3>Exception Message</h3>

						<div class="exception-box">
						
							<pre>{{EXCEPTION_MESSAGE}}</pre>
						
						</div>

					</div>

					</body>
					</html>
					""";

			html = html.replace("{{FAILURE_ID}}", nullSafe(investigation.getFailureId()));

			html = html.replace("{{TRACE_ID}}", nullSafe(investigation.getTraceId()));

			html = html.replace("{{TIMESTAMP}}", nullSafe(investigation.getTimestamp()));

			html = html.replace("{{TEST_NAME}}", nullSafe(investigation.getTestName()));

			html = html.replace("{{EXCEPTION_TYPE}}", nullSafe(investigation.getExceptionType()));

			html = html.replace("{{ROOT_CAUSE}}", nullSafe(investigation.getRootCause()));

			html = html.replace("{{SEVERITY}}", nullSafe(investigation.getSeverity()));

			html = html.replace("{{PRIORITY}}", nullSafe(investigation.getPriority()));

			html = html.replace("{{CONFIDENCE}}", String.valueOf(investigation.getConfidence()));

			html = html.replace("{{FINGERPRINT}}", nullSafe(investigation.getFingerprintId()));
			
			
			String screenshotLink = buildScreenshotLink(investigation.getScreenshotPath());

			String videoLink = buildVideoLink(investigation.getVideoPath());
			
			html = html.replace("{{SCREENSHOT_LINK}}", screenshotLink);

			html = html.replace("{{VIDEO_LINK}}", videoLink);


			html = html.replace("{{EXCEPTION_MESSAGE}}", nullSafe(investigation.getExceptionMessage()));

			File file = new File(
					"Reports/" + projectName + "/smart-trace/failures/" + investigation.getFailureId() + ".html");

			file.getParentFile().mkdirs();

			Files.writeString(file.toPath(), html);

		} catch (Exception e) {

			throw new RuntimeException("Failed to generate failure detail page", e);
		}
	}

	private String nullSafe(String value) {

		return value == null ? "" : value;
	}
	
	private String buildScreenshotLink(
	        String path
	) {

	    if (path == null || path.isBlank()) {

	        return "Not Available";
	    }

	    return "<a href='../../"
	            + path
	            + "' target='_blank'>"
	            + "View Screenshot"
	            + "</a>";
	}

	private String buildVideoLink(
	        String path
	) {

	    if (path == null || path.isBlank()) {

	        return "Not Available";
	    }

	    return "<a href='../../"
	            + path
	            + "' target='_blank'>"
	            + "View Video"
	            + "</a>";
	}
}
