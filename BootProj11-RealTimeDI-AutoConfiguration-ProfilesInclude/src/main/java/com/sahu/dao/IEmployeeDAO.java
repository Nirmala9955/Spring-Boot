package com.sahu.dao;

import java.util.List;

import com.sahu.bo.EmployeeBO;

public interface IEmployeeDAO {
	public List<EmployeeBO> getEmpsByDesgs(String condition) throws Exception;
}
