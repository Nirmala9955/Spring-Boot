package com.sahu.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) //UI screen type
				.select() //To specify RestController
				.apis(RequestHandlerSelectors.basePackage("com.sahu.controller")) //base package for RestController
				.paths(PathSelectors.regex("/tourist.*")) //To specify Request paths
				.build()
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Raja", "http://www.HCL.com/tourist", "raja@gmail.com");
		return new ApiInfo("Tourist", 
						"Gives info about tourist activites", 
						"3.4.RELEASE",
						"http://www.hcl.com/license", 
						contact, 
						"GNU public", 
						"http://apache.org/license/gnu", 
						Collections.emptyList());
	}
	
}
