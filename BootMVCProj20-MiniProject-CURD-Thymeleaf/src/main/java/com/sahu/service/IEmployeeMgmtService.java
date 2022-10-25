package com.sahu.service;

import com.sahu.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployees();
	public String insertEmployee(Employee emp);
	public Employee getEmployeeByEmpNo(Integer empno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeByEno(Integer eno);
}
