package com.sahu.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

	private List<String> listMessage = new ArrayList<>();
	
	public void addMessage(String message) {
		listMessage.add(message);
	}
	
	public String getAllMessage() {
		return listMessage.toString();
	}
	
}
