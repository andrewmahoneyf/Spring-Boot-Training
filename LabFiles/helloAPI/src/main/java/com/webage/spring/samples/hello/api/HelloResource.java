package com.webage.spring.samples.hello.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
    @GetMapping("/hello-message")
    public HelloResponse getMessage() {
        return new HelloResponse("Hello!");
    }
}
