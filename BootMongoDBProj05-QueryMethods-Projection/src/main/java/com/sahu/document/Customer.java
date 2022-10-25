package com.sahu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Customer {
	@Id
	private String id;
	private Integer cno;
	private String cname;
	private String caddress;
	private Double billAmt;
	private Long mobileNo;
}
