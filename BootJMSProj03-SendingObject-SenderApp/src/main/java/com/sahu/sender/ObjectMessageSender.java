package com.sahu.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sahu.model.ActorInfo;

@Component
public class ObjectMessageSender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(cron = "0/20 * * * * *")
	public void sendObjectDataAsMessage() {
		//Prepare object
		ActorInfo actor = new ActorInfo(1001, "Ranveer", "Mumbai");
		//Send object as Message
		jmsTemplate.convertAndSend("obj_mq1", actor);
		System.out.println("Object is send as message");
	}
}
