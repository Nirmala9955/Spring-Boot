package com.sahu.service;

import java.util.List;

import com.sahu.document.Customer;

public interface ICustomerMgmtService {
	public List<Object[]> fetchCustomersDataByAddress(String cAddress);
	public List<Customer> fetchCustomersByAddress(String cAddress);
	public List<Object[]> fetchCustomersByAddressAndName(String cAddress, String cName);
	public List<Object[]> fetchCustomersByAddressOrName(String cAddress, String cName);
	public List<Object[]> fetchCustomersByBillAmountRange(Double start, Double end);
	
	public List<Customer> fetchCustomersByRegAddress(String address);
	
	public Integer fetchCustomersCountByBillAmountRange(Double start, Double end);
	public List<Customer> fetchCustomersByBillAmountSorted();
	public Integer removeCustomersWithNoBillAmount();
	public Boolean checkCustomersExistWithBillAmountRang(Double start, Double end);
}
