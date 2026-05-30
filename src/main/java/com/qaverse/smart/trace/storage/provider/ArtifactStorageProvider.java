package com.qaverse.smart.trace.storage.provider;

public interface ArtifactStorageProvider {

	void saveArtifact(String artifactId, Object artifact);

	Object getArtifact(String artifactId);

	void deleteArtifact(String artifactId);
}