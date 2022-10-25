package com.sahu.service;

import java.util.List;

import com.sahu.entity.Customer;

public interface ICustomerMgmtService {
	public String registerCustomer(Customer customer);
	public List<Customer> getAllCustomer();
}
