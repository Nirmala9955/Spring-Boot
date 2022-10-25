package com.sahu.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingRestController {

	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummyBookTicket")
	public String bookTicket() {
		if (new Random().nextInt(10)<9)
			throw new RuntimeException("problem in business logic");
		
		return "Output from business logic";
	}
	
	public String dummyBookTicket() {
		System.out.println("TicketBookingRestController.dummyBookTicket()");
		return "Sorry please try latter Inconvenience regretted";
	}
	
}
