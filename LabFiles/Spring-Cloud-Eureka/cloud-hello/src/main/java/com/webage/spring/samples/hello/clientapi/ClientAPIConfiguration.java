package com.webage.spring.samples.hello.clientapi;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FailAfterProperties.class)
public class ClientAPIConfiguration {

}
