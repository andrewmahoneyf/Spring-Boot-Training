package com.webage.spring.samples.helloclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RibbonHelloClientApp {

	public static void main(String[] args) {
		SpringApplication.run(RibbonHelloClientApp.class, args);
	}
}
