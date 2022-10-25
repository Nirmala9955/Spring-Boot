package com.sahu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sahu.model.Employee;
import com.sahu.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeRepo employeeRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees() {
		return employeeRepo.findAll(Sort.by("job").ascending());
	}

	@Override
	public String insertEmployee(Employee emp) {
		return emp.getEname()+" details has registered and his Employee id is "+employeeRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByEmpNo(Integer empno) {
		return employeeRepo.findById(empno).get();
	}

	@Override
	public String updateEmployee(Employee emp) {
		return employeeRepo.save(emp).getEname()+" details has updated";
	}

	@Override
	public String deleteEmployeeByEno(Integer eno) {
		employeeRepo.deleteById(eno);
		return "Employee Id - "+eno+" details has deleted";
	}

	@Override
	public Page<Employee> getEmployeesPageData(Pageable pageable) {
		return employeeRepo.findAll(pageable);
	}

}
