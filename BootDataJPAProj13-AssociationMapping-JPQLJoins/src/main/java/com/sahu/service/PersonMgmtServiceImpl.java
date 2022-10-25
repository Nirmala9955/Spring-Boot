package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.repository.IPersonRepo;
import com.sahu.repository.IPhoneNumberRepo;

@Service("personMgmtService")
public class PersonMgmtServiceImpl implements IPersonMgmtService {
	
	@Autowired
	private IPersonRepo personRepo;
	
	@Autowired
	private IPhoneNumberRepo phoneNumberRepo;
	
	@Override
	public List<Object[]> fetchDataByJoinUsingParent() {
		return personRepo.fetchDataUsingJoinsByParent();
	}

}
