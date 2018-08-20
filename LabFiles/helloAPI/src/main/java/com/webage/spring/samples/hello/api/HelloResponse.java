package com.webage.spring.samples.hello.api;

public class HelloResponse {
    String message;

    public HelloResponse(String message){
        super();
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void SetMessage(String message){
        this.message = message;
    }
}
