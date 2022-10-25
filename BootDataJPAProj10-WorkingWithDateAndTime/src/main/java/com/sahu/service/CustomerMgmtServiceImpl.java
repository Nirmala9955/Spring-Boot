package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.entity.Customer;
import com.sahu.repo.ICustomerRepo;

@Service("customerService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Override
	public String registerCustomer(Customer customer) {
		int idVal = customerRepo.save(customer).getCustId();
		return "Customer is saved with id : "+idVal;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

}
