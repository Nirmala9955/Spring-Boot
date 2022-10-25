package com.sahu.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(15)
public class SecurityServiceRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SecurityServiceRunner.run()");
		System.out.println("Non-option args - "+args.getNonOptionArgs());
		System.out.println("Option Names - "+args.getOptionNames());
		System.out.println("Option values - "+args.getOptionValues(null));
		System.out.println("Source Args - "+Arrays.toString(args.getSourceArgs()));
	}

}
