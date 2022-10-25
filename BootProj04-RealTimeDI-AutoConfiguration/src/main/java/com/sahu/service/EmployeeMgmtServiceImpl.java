package com.sahu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.bo.EmployeeBO;
import com.sahu.dao.IEmployeeDAO;
import com.sahu.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDegs(String[] desgs) throws Exception {
		// Convert desg[] into SQL IN clause String Condition
		StringBuffer condition = new StringBuffer("(");
		for (int i = 0; i < desgs.length; i++) {
			if (i == desgs.length - 1)
				condition.append("'" + desgs[i] + "')");
			else
				condition.append("'" + desgs[i] + "',");
		}
		// Use DAO
		List<EmployeeBO> listBO = dao.getEmpsByDesgs(condition.toString());
		// Convert ListBO to ListDTO
		List<EmployeeDTO> listDTO = new ArrayList<>();
		listBO.forEach(bo -> {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size() + 1);
			// add each object of DTO class into listDTO
			listDTO.add(dto);
		});
		return listDTO;
	}

}
