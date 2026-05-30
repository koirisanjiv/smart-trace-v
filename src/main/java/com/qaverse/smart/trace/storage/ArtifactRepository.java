package com.qaverse.smart.trace.storage;

import com.qaverse.smart.trace.storage.provider.ArtifactStorageProvider;
import com.qaverse.smart.trace.storage.provider.InMemoryArtifactStorageProvider;

public class ArtifactRepository {

	private final ArtifactStorageProvider artifactStorageProvider = new InMemoryArtifactStorageProvider();

	public void saveArtifact(String artifactId, Object artifact) {

		artifactStorageProvider.saveArtifact(artifactId, artifact);
	}

	public Object getArtifact(String artifactId) {

		return artifactStorageProvider.getArtifact(artifactId);
	}

	public void deleteArtifact(String artifactId) {

		artifactStorageProvider.deleteArtifact(artifactId);
	}
}