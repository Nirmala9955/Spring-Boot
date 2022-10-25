package com.sahu.service;

import java.util.List;

import com.sahu.document.Customer;

public interface ICustomerMgmtService {
	public String registerCustomer(Customer customer);
	
	public List<Customer> findAllCustomer();
	public String removeCustomer(String id);
	
	public List<Customer> fetchCustomerByBillAmtRange(Double start, Double end);
	public List<Customer> fetchCustomerByUsingCaddressAndHavingMobileNo(String... addresses);
}
