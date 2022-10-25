package com.sahu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PostingJSONData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate class object
		RestTemplate restTemplate = new RestTemplate();
		//Define URL
		String serviceURL = "http://localhost:3035/BootRestProj14-ProviderApplication/actor/register";
		//Prepare JSON Data (JSON body)
		String json_body = "{\"aid\":1001, \"name\":\"Ranveer\", \"age\":30, \"type\":\"hero\"}";
		//Prepare Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//Prepare HTTP request as HttpEntiry object having Head, body
		HttpEntity<String> entity = new HttpEntity<String>(json_body, headers);
		//Make HTTP request call in post mode
		ResponseEntity<String> response = restTemplate.exchange(serviceURL, HttpMethod.POST, entity, String.class);
		//Display the received details from the response
		System.out.println("Response body (output) - "+response.getBody());	
		System.out.println("Response status code value - "+response.getStatusCodeValue());
		System.out.println("Response stauts code - "+response.getStatusCode().name());
	}

}
