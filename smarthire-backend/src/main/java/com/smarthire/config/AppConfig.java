package com.smarthire.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${smarthire.app-name}")

	private String appName;

	public String getAppName() {
		return appName;

	}

}
