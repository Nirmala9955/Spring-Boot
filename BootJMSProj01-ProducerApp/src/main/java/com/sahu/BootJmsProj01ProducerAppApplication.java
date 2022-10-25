package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJmsProj01ProducerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj01ProducerAppApplication.class, args);
	}

}
