package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class BootMsProj08CircuitBrakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08CircuitBrakerApplication.class, args);
	}

}
