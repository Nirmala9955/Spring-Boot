package com.sahu.service;

import java.util.List;

import com.sahu.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO> fetchEmpsByDegs(String desgs[]) throws Exception;
}
