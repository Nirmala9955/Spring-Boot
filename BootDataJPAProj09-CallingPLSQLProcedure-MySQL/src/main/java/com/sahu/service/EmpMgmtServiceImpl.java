package com.sahu.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.Emp;

@Service
public class EmpMgmtServiceImpl implements IEmpMgmtService {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Emp> searchEmployeesByDesgs(String desg1, String desg2) {
		//Create StoredProcedureQuery object
		StoredProcedureQuery query = manager.createStoredProcedureQuery("GET_EMP_DETAILS_BY_DESGS", Emp.class);
		//register Parameters of PL/ SQL procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		//Set values to parameter
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);
		//Call PL/ SQL procedure
		List<Emp> listEmps = query.getResultList();
		return listEmps;
	}

}
