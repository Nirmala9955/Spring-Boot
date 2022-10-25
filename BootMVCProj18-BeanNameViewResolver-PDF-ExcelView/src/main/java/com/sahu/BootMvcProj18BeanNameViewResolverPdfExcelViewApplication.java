package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class BootMvcProj18BeanNameViewResolverPdfExcelViewApplication {

	@Bean
	public BeanNameViewResolver createBNVR() {
		System.out.println("BootMvcProj18BeanNameViewResolverPdfExcelViewApplication.createBNVR()");
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		//resolver.setOrder(1);
		return resolver;
	}
	
	/*	@Bean
	 	public InternalResourceViewResolver createIRVR() {
			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setSuffix(".jsp");
			resolver.setOrder(10);
			return resolver;
		}
		*/
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj18BeanNameViewResolverPdfExcelViewApplication.class, args);
	}

}
