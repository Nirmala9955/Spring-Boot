package com.sahu.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQMessageSender {

	@Autowired
	private JmsTemplate template;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage() {
		template.send("testmq1", ses-> ses.createTextMessage("From sender at : "+new Date()));
		System.out.println("Message Sent");
	}

}
