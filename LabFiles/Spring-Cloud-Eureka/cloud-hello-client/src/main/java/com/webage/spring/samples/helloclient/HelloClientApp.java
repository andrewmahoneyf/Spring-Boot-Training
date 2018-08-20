package com.webage.spring.samples.helloclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloClientApp {

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApp.class, args);
	}
}
