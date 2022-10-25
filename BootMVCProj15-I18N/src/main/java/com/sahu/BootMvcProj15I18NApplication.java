package com.sahu;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj15I18NApplication {
	
	@Bean("messageSource") //Fixed bean Id
	public ResourceBundleMessageSource createRBMS() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("com/sahu/commons/App");
		return source;
	} 

	@Bean("localeResolver") //Fixed bean Id
	public SessionLocaleResolver createSLResover() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.ENGLISH);
		return resolver;
	}
	
	@Bean("lci") //Not fixed bean Id
	public LocaleChangeInterceptor createLCInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj15I18NApplication.class, args);
	}

}
