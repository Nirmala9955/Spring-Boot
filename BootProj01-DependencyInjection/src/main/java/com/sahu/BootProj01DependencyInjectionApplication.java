package com.sahu;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sahu.beans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01DependencyInjectionApplication {

	@Bean("lTD")
	public LocalDateTime createLocalDateTime() {
		System.out.println("BootProj01DependencyInjectionApplication.createLocalDateTime()");
		return LocalDateTime.now();
	}
	
	public static void main(String[] args) {
		//get IoC container
		ApplicationContext ctx = SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//get target spring bean class from IoC container
		//WishMessageGenerator wGenerator = ctx.getBean(wmg"", WishMessageGenerator.class);
		WishMessageGenerator wGenerator = ctx.getBean(WishMessageGenerator.class);
		//invoke method
		System.out.println(wGenerator.generateWishMessage("Sahu"));
		//close container 
		((ConfigurableApplicationContext) ctx).close();
	}

}
