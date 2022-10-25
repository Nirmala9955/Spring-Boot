package com.sahu.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate class object
		RestTemplate restTemplate = new RestTemplate();
		//Define URL
		String serviceURL = "http://localhost:3035/BootRestProj13-ProviderApplication/actor/wish/{id}/{name}";
		//Generate HTTP request call with GET mode to consume the web service  (API).
		//ResponseEntity<String> response = restTemplate.getForEntity(serviceURL, String.class, 101, "Raja");
		ResponseEntity<String> response = restTemplate.getForEntity(serviceURL, String.class, Map.of("name", "Rajesh", "id", 101));
		//Display the received details from the response
		System.out.println("Response body (output) - "+response.getBody());	
		System.out.println("Response status code value - "+response.getStatusCodeValue());
		System.out.println("Response stauts code - "+response.getStatusCode().name());	
		System.out.println("Response header - "+response.getHeaders());	
	}

}
