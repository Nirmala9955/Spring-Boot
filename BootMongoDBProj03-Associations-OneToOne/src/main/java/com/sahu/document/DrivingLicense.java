package com.sahu.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class DrivingLicense {
	@Id
	private Long lId;
	private String type;
	private LocalDate expiryDate;
	private Person person;
	
	public DrivingLicense() {
		System.out.println("DrivingLicense.DrivingLicense()");
	}
	
	@Override
	public String toString() {
		return "DrivingLicense [lId=" + lId + ", type=" + type + ", expiryDate=" + expiryDate + "]";
	}
}
