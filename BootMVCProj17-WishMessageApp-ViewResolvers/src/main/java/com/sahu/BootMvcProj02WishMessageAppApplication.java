package com.sahu;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@SpringBootApplication
public class BootMvcProj02WishMessageAppApplication {
	
	/*@Bean
	public UrlBasedViewResolver createUBVR() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(InternalResourceView.class);
		return resolver;
	}*/
	
	/*@Bean
	public ResourceBundleViewResolver createRBVR() {
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setBasename("com/sahu/commons/views");
		return resolver;
	}*/
	
	@Autowired
	private ServletContext sc;
	
	@Bean
	public XmlViewResolver createXVR() {
		XmlViewResolver resolver = new XmlViewResolver();
		resolver.setLocation(new FileSystemResource(sc.getRealPath("/")+"/WEB-INF/views.xml"));
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj02WishMessageAppApplication.class, args);
	}

}
