package com.sahu.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsmer {

	@Autowired
	private MessageStore messageStore;
	
	@KafkaListener(topics = "${app.topic.name}", groupId="grp1")
	public void readMessage(String message) {
		//add messages to store
		messageStore.addMessage(message);
	}
	
}
