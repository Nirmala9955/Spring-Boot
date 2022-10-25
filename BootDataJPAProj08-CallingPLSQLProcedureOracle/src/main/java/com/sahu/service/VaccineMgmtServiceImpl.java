package com.sahu.service;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.CoronaVaccine;

@Service
public class VaccineMgmtServiceImpl implements IVaccineMgmtService {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<CoronaVaccine> searchVaccineByPriceRange(Double min, Double max) {
		//Create Stored Procedure object representing PL/ SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_VACCINE_BY_PRICERANGE", CoronaVaccine.class);
		//register Parameters of PL/ SQL procedure
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, CoronaVaccine.class, ParameterMode.REF_CURSOR);
		//Set values to parameter
		query.setParameter(1, min);
		query.setParameter(2, max);
		//Call PL/ SQL procedure
		List<CoronaVaccine> listVaccine = query.getResultList();
		return listVaccine;
	}

	@Override
	public String authenticate(String userName, String password) {
		//Create Stored Procedure object representing PL/ SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_AUTHENTICATION");
		//register Parameters of PL/ SQL procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//Set values to parameter
		query.setParameter(1, userName);
		query.setParameter(2, password);
		//Call PL/ SQL procedure
		query.execute();
		//Gather results out parameter value
		String result = (String) query.getOutputParameterValue(3);
		return result;
	}

	@Override
	public Object[] getEmpDetailsByEno(int eno) {
		//Unwrap session object from EntityManagger
		Session ses = manager.unwrap(Session.class);
		//Work with ReturningWork<T> interface to write plain JDBC code to call PL/ SQL fucntion
		Object obj[] = ses.doReturningWork(conn->{
			//Create CallableStatement object
			CallableStatement cs = conn.prepareCall("{?=call FX_GET_EMP_DETAILS(?,?,?,?)}");
			//Register OUT parameters
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.FLOAT);
			//Set value to IN parameters
			cs.setInt(2, eno);
			//Call PL/ SQL Function
			cs.execute();
			//Gater Results from return OUT parameter
			Object result[] = new Object[4];
			result[0] = cs.getInt(1);
			result[1] = cs.getInt(3);
			result[2] = cs.getInt(4);
			result[4] = cs.getInt(5);
			return result;
		});
		return obj;
	}

}
