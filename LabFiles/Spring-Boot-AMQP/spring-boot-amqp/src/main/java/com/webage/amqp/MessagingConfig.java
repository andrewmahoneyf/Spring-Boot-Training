package com.webage.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    @Bean
    public Queue myQueue() {
        return new Queue("myqueue1");
    }

}
