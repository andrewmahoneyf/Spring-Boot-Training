package com.webage.amqp;

import com.webage.domain.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @RabbitListener(queues = "myqueue1")
    public void onMessage(Order order) {
        System.out.println("Message recieved - Order Details:" + order);
    }
}
