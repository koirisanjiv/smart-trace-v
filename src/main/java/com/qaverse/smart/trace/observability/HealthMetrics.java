package com.qaverse.smart.trace.observability;

public class HealthMetrics {

	private double cpuUsage;

	private double memoryUsage;

	private long activeThreads;

	public double getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(double cpuUsage) {

		this.cpuUsage = cpuUsage;
	}

	public double getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(double memoryUsage) {

		this.memoryUsage = memoryUsage;
	}

	public long getActiveThreads() {
		return activeThreads;
	}

	public void setActiveThreads(long activeThreads) {

		this.activeThreads = activeThreads;
	}

	@Override
	public String toString() {

		return "HealthMetrics{" + "cpuUsage=" + cpuUsage + ", memoryUsage=" + memoryUsage + ", activeThreads="
				+ activeThreads + '}';
	}
}