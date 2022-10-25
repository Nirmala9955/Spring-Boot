package com.sahu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sahu.exception.EmployeeNotFoundException;
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
		/*Optional<Employee> opt = employeeRepo.findById(empno);
		if (opt.isPresent())
			return opt.get();
		else
			throw new EmployeeNotFoundException("Employee with "+empno+" not found.");*/
		//Alternet code
		return employeeRepo.findById(empno).orElseThrow(()->new EmployeeNotFoundException("Employee with "+empno+" not found."));
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

}
