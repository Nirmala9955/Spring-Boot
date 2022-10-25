package com.sahu.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class JdbcServiceRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("JdbcServiceRunner.run()");
		for (String arg : args) {
			System.out.println(arg);
		}
	}

}
