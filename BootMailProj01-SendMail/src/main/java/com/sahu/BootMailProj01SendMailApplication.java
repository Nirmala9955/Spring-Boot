package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sahu.service.IPurchaseOrder;

@SpringBootApplication
public class BootMailProj01SendMailApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootMailProj01SendMailApplication.class, args);
		//get service class 
		IPurchaseOrder order = ctx.getBean("purchaseService" ,IPurchaseOrder.class);
		//invoke method
		try {
			String message = order.purchase(new String[] {"shirt", "trouser", "watch"},
						   new double[] {5000, 6000, 7000}, 
						   new String[] {"nirmalakumarsahu7@gmail.com", "papusahu554@gmail.com"});
			System.out.println(message);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}
