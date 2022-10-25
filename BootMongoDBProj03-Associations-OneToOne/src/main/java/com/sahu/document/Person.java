package com.sahu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Person {
	@Id
	private Integer pId;
	private String pName;
	private String pAddress;
	private DrivingLicense license; //HAS-A Property
	
	public Person() {
		System.out.println("Person.Person()");
	}
	
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pAddress=" + pAddress + "]";
	}
}
