package com.qaverse.smart.trace.cache;

public class TraceCacheManager {

	private final ArtifactCache artifactCache = new ArtifactCache();

	private final ExecutionCache executionCache = new ExecutionCache();

	private final CorrelationCache correlationCache = new CorrelationCache();

	public ArtifactCache getArtifactCache() {
		return artifactCache;
	}

	public ExecutionCache getExecutionCache() {
		return executionCache;
	}

	public CorrelationCache getCorrelationCache() {
		return correlationCache;
	}

	public void clearAll() {

		artifactCache.clear();

		executionCache.clear();

		correlationCache.clear();
	}
}