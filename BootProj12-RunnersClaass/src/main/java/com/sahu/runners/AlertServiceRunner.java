package com.sahu.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-20)
public class AlertServiceRunner implements CommandLineRunner, Ordered {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AlertServiceRunner.run()");
		for (String arg : args) {
			System.out.println(arg);
		}
	}

	@Override
	public int getOrder() {
		return 15;
	}

}