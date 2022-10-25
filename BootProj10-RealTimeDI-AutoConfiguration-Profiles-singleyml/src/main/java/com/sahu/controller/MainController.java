package com.sahu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sahu.dto.EmployeeDTO;
import com.sahu.service.IEmployeeMgmtService;
import com.sahu.vo.EmployeeVO;

@Controller("mainController")
public class MainController {

	@Autowired
	private IEmployeeMgmtService service;
	
	public List<EmployeeVO> showEmpsByDesgs(String desgs[]) throws Exception {
		//User service
		List<EmployeeDTO> listDTO = service.fetchEmpsByDegs(desgs);
		//Convert listDTO to listVO;
		List<EmployeeVO> listVO = new ArrayList<>();
		listDTO.forEach(dto->{
			EmployeeVO vo = new EmployeeVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setSrNo(String.valueOf(dto.getSrNo()));
			vo.setEmpNo(String.valueOf(dto.getEmpNo()));
			vo.setSal(String.valueOf(dto.getSal()));
			vo.setDeptNo(String.valueOf(dto.getDeptNo()));
			vo.setMgrNo(String.valueOf(dto.getMgrNo()));
			listVO.add(vo);
		});
		return listVO; 
	}
}
