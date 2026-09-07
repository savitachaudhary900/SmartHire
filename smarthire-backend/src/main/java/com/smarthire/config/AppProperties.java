package com.smarthire.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "smarthire")
public class AppProperties {

	private String appName;
	private int maxCandidates;
	private int maxJobs;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getMaxCandidates() {
		return maxCandidates;
	}

	public void setMaxCandidates(int maxCandidates) {
		this.maxCandidates = maxCandidates;
	}

	public int getMaxJobs() {
		return maxJobs;
	}

	public void setMaxJobs(int maxJobs) {
		this.maxJobs = maxJobs;
	}

}
