package com.sahu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.document.Customer;
import com.sahu.repository.ICustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Override
	public String registerCustomer(Customer customer) {
		return "Customer "+customerRepo.save(customer).getCname()+" has saved.";
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public String removeCustomer(String id) {
		//Get Document by id
		Optional<Customer> optCustomer = customerRepo.findById(id);
		if (optCustomer.isPresent()) {
			customerRepo.delete(optCustomer.get());
			return "Docuemnt has deleted";
		}
		return "Document not found";
	}

	@Override
	public List<Customer> fetchCustomerByBillAmtRange(Double start, Double end) {
		return customerRepo.findByBillAmtBetween(start, end);
	}

	@Override
	public List<Customer> fetchCustomerByUsingCaddressAndHavingMobileNo(String... addresses) {
		return customerRepo.findByCaddressInAndMobileNoIsNotNull(addresses);
	}

}
