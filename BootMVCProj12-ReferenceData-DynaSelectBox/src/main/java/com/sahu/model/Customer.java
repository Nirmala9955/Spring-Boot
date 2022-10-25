package com.sahu.model;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String[] languages=new String[] {"English", "Hindi"};
	private String hobbies[] = new String[] {"Swimming", "Workout"};
	private String country;
	private String state;
}
