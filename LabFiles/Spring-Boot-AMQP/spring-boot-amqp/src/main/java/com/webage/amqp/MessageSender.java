package com.webage.amqp;

import com.webage.domain.Order;

public interface MessageSender {
	public void sendOrderMessage(Order toSend);
	
}
