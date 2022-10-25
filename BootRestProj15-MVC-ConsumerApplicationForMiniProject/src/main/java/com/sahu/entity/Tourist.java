package com.sahu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tourist {
	private Integer tid;
	private String name;
	private String city;
	private String packageType;
	private Double budget;
}
