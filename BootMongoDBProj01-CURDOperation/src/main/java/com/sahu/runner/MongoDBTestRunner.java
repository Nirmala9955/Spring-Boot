package com.sahu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.document.Customer;
import com.sahu.generator.IDGenerator;
import com.sahu.service.ICustomerMgmtService;

@Component
public class MongoDBTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICustomerMgmtService customerMgmtService;
	
	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = new Customer();
		customer1.setCno(1001);
		customer1.setCname("Ramesh");
		customer1.setCaddress("Hyd");
		customer1.setBillAmt(34533.0);
		//System.out.println(customerMgmtService.registerCustomer(customer1));
		
		Customer customer2 = new Customer();
		customer2.setId(IDGenerator.generateId());
		customer2.setCno(1002);
		customer2.setCname("Mahesh");
		customer2.setCaddress("Vizag");
		customer2.setBillAmt(3453.67);
		customer2.setMobileNo(2345678976l);
		//System.out.println(customerMgmtService.registerCustomer(customer2));
		
		//customerMgmtService.findAllCustomer().forEach(System.out::println);
		
		//System.out.println(customerMgmtService.removeCustomer("61ca7bac6c3c454f1b5e4f90"));
		
		//--------------Finder methods ------------------
		customerMgmtService.fetchCustomerByBillAmtRange(3000.0,10000.0).forEach(System.out::println);
		customerMgmtService.fetchCustomerByUsingCaddressAndHavingMobileNo("Hyd", "Delhi").forEach(System.out::println);
	}

}
