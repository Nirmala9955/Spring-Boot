package com.sahu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate class object
		RestTemplate restTemplate = new RestTemplate();
		//Define URL
		String wishURL = "http://localhost:3035/BootRestProj14-ProviderApplication/actor/wish";
		
		//Invoke service method/ operation using exchange(-,-,-) method
		ResponseEntity<String> response = restTemplate.exchange(wishURL, HttpMethod.GET, null, String.class);
		//Display the details
		System.out.println("Response body (output) - "+response.getBody());	
		System.out.println("Response status code value - "+response.getStatusCodeValue());
		System.out.println("Response stauts code - "+response.getStatusCode().name());
	}

}
