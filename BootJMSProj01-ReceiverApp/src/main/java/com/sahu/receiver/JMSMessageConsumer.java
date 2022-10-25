package com.sahu.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSMessageConsumer {

	@JmsListener(destination = "testmq1")
	public void readMessage(String text) {
		System.out.println("Received message is : "+text);
	}
}
