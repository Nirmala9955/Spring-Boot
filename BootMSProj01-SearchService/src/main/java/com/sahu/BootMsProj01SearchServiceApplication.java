package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootMsProj01SearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj01SearchServiceApplication.class, args);
	}

}
