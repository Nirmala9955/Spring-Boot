package com.sahu.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahu.model.Actor;

@Component
public class ActorServiceConsuming_Getting_JSONData_Runner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//Create RestTemplate class object
		RestTemplate restTemplate = new RestTemplate();
		//Define URL
		String serverURL = "http://localhost:3035/BootRestProj14-ProviderApplication/actor/findAll";
		
		//Invoke service method/ operation using exchange(-,-,-) method
		ResponseEntity<String> response = restTemplate.exchange(serverURL, HttpMethod.GET, null, String.class);
		
		//Display the details
		System.out.println("Response body (output) - "+response.getBody());	
		System.out.println("Response status code value - "+response.getStatusCodeValue());
		System.out.println("Response stauts code - "+response.getStatusCode().name());
		System.out.println("------------------------------------");
		
		//Convert JSON Text response (body) to Java class object/  model class object/ Entity class object using JACSON API
		String jsonBody = response.getBody();
		//Create ObjectMapper
		ObjectMapper mapper = new ObjectMapper(); 
		Actor[] actor = mapper.readValue(jsonBody, Actor[].class);
		List<Actor> listActor = Arrays.asList(actor);
		System.out.println(listActor);
		System.out.println("-------------------------------------");
		List<Actor> listActors = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {});
		listActors.forEach(System.out::println);
	}

}
