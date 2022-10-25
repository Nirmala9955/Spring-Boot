package com.sahu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.model.Employee;
import com.sahu.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo employeeRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

}
