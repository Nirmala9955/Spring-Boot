package com.sahu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sahu.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	/**
	 * This method is given to check weather handler
	 * method is passing correct command class object 
	 * or not.
	 * If passed it calls validate(-,-) method other
	 * wise throws exception.
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("EmployeeValidator.supports()");
		//return Employee.class==clazz;
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate()");
		//Type casting
		Employee emp = (Employee) target;
		//server side form  validation logic
		if (emp.getEname()==null||emp.getEname().isBlank())
			errors.rejectValue("ename", "emp.ename.required");
		else if (emp.getEname().length()<5)
			errors.rejectValue("ename", "emp.ename.minilength");

		if (emp.getJob()==null||emp.getJob().isBlank())
			errors.rejectValue("job", "emp.desg.required");
		else if (emp.getJob().length()<5)
			errors.rejectValue("ename", "emp.desg.minilength");

		if (emp.getSal()==null)
			errors.rejectValue("sal", "emp.sal.required");
		else if (emp.getSal().isNaN())
			errors.rejectValue("sal", "emp.sal.numeric");
		else if (emp.getSal()<10000 || emp.getSal()>100000)
			errors.rejectValue("sal", "emp.sal.range");

		if (emp.getDeptno()==null)
			errors.rejectValue("deptno", "emp.detpno.required");
		else if (((Float)emp.getDeptno().floatValue()).isNaN())
			errors.rejectValue("deptno", "emp.detpno.numeric");
		else if (emp.getDeptno()<10 || emp.getDeptno()>100)
			errors.rejectValue("deptno", "emp.detpno.range");
	}

}
