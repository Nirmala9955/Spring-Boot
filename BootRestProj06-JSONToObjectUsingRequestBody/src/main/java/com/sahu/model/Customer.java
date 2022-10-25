package com.sahu.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String[] favColors;
	private List<String> academics;
	private Set<Long> phonNo;
	private Map<String, Double> billDetails;
	private Address address;
}
