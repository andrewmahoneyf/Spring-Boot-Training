package com.webage.spring.samples.hello.clientapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="failAfter")
public class FailAfterProperties {
	boolean enabled=false;
	int count=100;
	long failureTime=0;
	int requestCount=0;
	
	public long getFailureTime() {
		return failureTime;
	}
	public void setFailureTime(long failureTime) {
		this.failureTime = failureTime;
	}
	public int getRequestCount() {
		return requestCount;
	}
	public void setRequestCount(int requestCount) {
		this.requestCount = requestCount;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
