package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootKafkaProj02RestWithKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaProj02RestWithKafkaApplication.class, args);
	}

}
