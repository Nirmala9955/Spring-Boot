package com.sahu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.model.Cricketer;
import com.sahu.repository.ICricketerRepo;

@Service
public class CricketerMgmtServiceImpl implements ICricketerMgmtService {
	
	@Autowired
	private ICricketerRepo cricketerRepo;
	
	@Override
	public String registerCricketer(Cricketer cricketer) {
		return cricketerRepo.save(cricketer).getName()+" detils has registered";
	}

}
