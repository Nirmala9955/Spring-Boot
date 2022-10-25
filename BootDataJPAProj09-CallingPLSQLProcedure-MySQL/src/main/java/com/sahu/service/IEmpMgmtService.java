package com.sahu.service;

import java.util.List;

import com.sahu.entity.Emp;

public interface IEmpMgmtService {
	public List<Emp> searchEmployeesByDesgs(String desg1, String desg2);	
}
