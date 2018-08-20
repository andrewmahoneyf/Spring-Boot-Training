package com.webage.spring.samples.helloclient;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-hello")
public interface HelloAPI {
	@RequestMapping(value="/hello-message", method=RequestMethod.GET)
	public Map<String, Object> getGreeting(@RequestParam("name") String name);
}
