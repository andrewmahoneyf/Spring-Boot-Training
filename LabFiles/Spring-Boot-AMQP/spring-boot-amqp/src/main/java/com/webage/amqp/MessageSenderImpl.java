package com.webage.amqp;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webage.domain.Order;

@Component
public class MessageSenderImpl implements MessageSender {

	@Autowired
    private AmqpTemplate amqpTemplate=null;

	@Override
    public void sendOrderMessage(Order toSend) {
	    System.out.println("Sending message with order - " + toSend);
	    amqpTemplate.convertAndSend("myqueue1", toSend);
    }

}
