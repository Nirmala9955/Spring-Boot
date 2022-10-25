package com.sahu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sahu.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DEGS = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO, MGR FROM EMP WHERE JOB IN";

	@Autowired
	private DataSource ds;

	@Override
	public List<EmployeeBO> getEmpsByDesgs(String condition) throws Exception {
		List<EmployeeBO> listBO = null;
		try ( // Get Pooled JDBC connection
				Connection con = ds.getConnection();
				// Statement Object
				Statement st = con.createStatement();
				// Send and execute SQL query in DB s/w
				ResultSet rs = st.executeQuery(GET_EMPS_BY_DEGS + condition + "ORDER BY JOB");) {
			// Convert RS to ListBO
			listBO = new ArrayList<>();
			EmployeeBO bo = null;
			while (rs.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getDouble(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgrNo(rs.getInt(6));
				// Add each object of Employee BO to List collection
				listBO.add(bo);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}

}
