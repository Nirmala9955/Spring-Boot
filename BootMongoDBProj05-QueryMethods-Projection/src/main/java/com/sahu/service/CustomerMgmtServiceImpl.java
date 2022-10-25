package com.sahu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.document.Customer;
import com.sahu.repo.ICustomerRepo;

@Service("customerService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Override
	public List<Object[]> fetchCustomersDataByAddress(String cAddress) {
		return customerRepo.getCustomersDataAddress(cAddress);
	}

	@Override
	public List<Customer> fetchCustomersByAddress(String cAddress) {
		return customerRepo.getCustomersByAddress(cAddress);
	}

	@Override
	public List<Object[]> fetchCustomersByAddressAndName(String cAddress, String cName) {
		return customerRepo.getCustomersByAddressAndName(cAddress, cName);
	}

	@Override
	public List<Object[]> fetchCustomersByAddressOrName(String cAddress, String cName) {
		return customerRepo.getCustomersByAddressOrName(cAddress, cName);
	}

	@Override
	public List<Object[]> fetchCustomersByBillAmountRange(Double start, Double end) {
		return customerRepo.getCustomersByBillAmountRange(start, end);
	}

	@Override
	public List<Customer> fetchCustomersByRegAddress(String address) {
		return customerRepo.getCustomersByRegAddress(address);
	}

	@Override
	public Integer fetchCustomersCountByBillAmountRange(Double start, Double end) {
		return customerRepo.getCustomersCountByBillAmountRange(start, end);
	}

	@Override
	public List<Customer> fetchCustomersByBillAmountSorted() {
		return customerRepo.getCustomersByBillAmountSorted();
	}

	@Override
	public Integer removeCustomersWithNoBillAmount() {
		return customerRepo.deleteCustomersWithNoBillAmount();
	}

	@Override
	public Boolean checkCustomersExistWithBillAmountRang(Double start, Double end) {
		return customerRepo.areThereCustomersWithBillAmountRang(start, end);
	}

}
