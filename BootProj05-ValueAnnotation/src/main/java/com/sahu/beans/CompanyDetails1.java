package com.sahu.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("company1")
public class CompanyDetails1 {
	@Value("${org.sahu.name}")
	private String title;	
	@Value("${org.sahu.type}")
	private String type;
	@Value("${org.sahu.location}")
	private String addrs;
	
	@Override
	public String toString() {
		return "CompanyDetails [title=" + title + ", type=" + type + ", addrs=" + addrs + "]";
	} 
}
