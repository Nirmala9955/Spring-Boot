package com.sahu.publisher;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessagePublisher implements CommandLineRunner {

	@Autowired
	private JmsTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		template.send("topic1", ses-> ses.createTextMessage("From sender at : "+new Date()));
		System.out.println("Message Sent");
	}

}
