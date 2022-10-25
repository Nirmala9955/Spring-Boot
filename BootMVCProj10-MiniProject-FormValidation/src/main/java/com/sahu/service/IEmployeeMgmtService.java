package com.sahu.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sahu.model.Employee;

public interface IEmployeeMgmtService {
	public Page<Employee> getEmployeesPageData(Pageable pageable);
	public Iterable<Employee> getAllEmployees();
	public String insertEmployee(Employee emp);
	public Employee getEmployeeByEmpNo(Integer empno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeByEno(Integer eno);
}
