package com.sahu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Actor {
	@Id
	private Integer actorId;
	private String actorName;
	private String category;
	private Float age;
	private Long mobileNo;
	private Double renumeration;
}
