package com.sahu.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSMessageSubscriber {

	@JmsListener(destination = "topic1")
	public void readMessage(String text) {
		System.out.println("Received message is : "+text);
	}
	
}
