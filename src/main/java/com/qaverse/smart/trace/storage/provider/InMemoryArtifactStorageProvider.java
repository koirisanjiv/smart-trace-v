package com.qaverse.smart.trace.storage.provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryArtifactStorageProvider implements ArtifactStorageProvider {

	private final Map<String, Object> artifacts = new ConcurrentHashMap<>();

	@Override
	public void saveArtifact(String artifactId, Object artifact) {

		artifacts.put(artifactId, artifact);
	}

	@Override
	public Object getArtifact(String artifactId) {

		return artifacts.get(artifactId);
	}

	@Override
	public void deleteArtifact(String artifactId) {

		artifacts.remove(artifactId);
	}
}