package com.sahu.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer srNo;
	private Integer empNo;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptNo;
	private Integer mgrNo;
}
