package com.sahu.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sahu.interceptor.TimeOutCheckInterceptor;

@Component
public class CustomConfigurer implements WebMvcConfigurer {
	
	public CustomConfigurer() {
		System.out.println("CustomConfigurer.CustomConfigurer()");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("CustomConfigurer.addInterceptors()");
		registry.addInterceptor(new TimeOutCheckInterceptor());
	}
	
}
