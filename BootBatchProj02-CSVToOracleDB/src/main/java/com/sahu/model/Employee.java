package com.sahu.model;

import lombok.Data;

@Data
public class Employee {
	private Integer empno;
	private String ename;
	private Integer salary;
	private String eaddress;
	private Integer grossSalary;
	private Integer netSalary;
}
