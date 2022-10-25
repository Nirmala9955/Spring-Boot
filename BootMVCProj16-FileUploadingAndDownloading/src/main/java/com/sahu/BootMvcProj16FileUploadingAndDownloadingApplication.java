package com.sahu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingAndDownloadingApplication {
	
	@Bean("multpartResolver")
	public CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver  resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(20*1024*1024);
		resolver.setPreserveFilename(true);
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingAndDownloadingApplication.class, args);
	}

}
