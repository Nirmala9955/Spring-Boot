package com.sahu.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.entity.Customer;
import com.sahu.service.ICustomerMgmtService;

@Component
public class DateAndTimeTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerMgmtService customerMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer("Raja", "Hyd", 
				LocalDateTime.of(1999, 10, 23, 15, 10, 3), 
				LocalTime.now(),
				LocalDate.now());
		System.out.println(customerMgmtService.registerCustomer(customer));
		
		customerMgmtService.getAllCustomer().forEach(System.out::println);
	}

}
