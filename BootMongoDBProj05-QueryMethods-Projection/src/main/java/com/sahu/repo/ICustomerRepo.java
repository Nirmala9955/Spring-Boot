package com.sahu.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sahu.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, Integer> {
	@Query(fields = "{id:1, cno:1, cname:1, caddress:1}", value = "{caddress:?0}")
	public List<Object[]> getCustomersDataAddress(String cAddress);
	
	//@Query(fields = "{}", value = "{caddress:?0}")
	@Query(value = "{caddress:?0}")
	public List<Customer> getCustomersByAddress(String cAddress);
	
	@Query(fields = "{id:1, cno:1, cname:1, caddress:1}", value = "{caddress:?0, cname:?1}")
	public List<Object[]> getCustomersByAddressAndName(String cAddress, String cName);
	
	//@Query(value="{$or:[{field1:?0}, {field2:?1}]}")
	@Query(fields = "{id:1, cno:1, cname:1, caddress:1}", value = "{$or:[{caddress:?0}, {cname:?1}]}")
	public List<Object[]> getCustomersByAddressOrName(String cAddress, String cName);
	
	//@Query(value="{field1::{$gte:?0}, field2:{$lte:?1}}")
	//@Query(fields = "{id:1, cno:1, cname:1, caddress:1, billAmt:1}", value = "{billAmt:{$gte:?0}, billAmt:{$lte:?1}}")
	@Query(fields = "{id:1, cno:1, cname:1, caddress:1, billAmt:1}", value = "{billAmt:{$gte:?0, $lte:?1}}")
	public List<Object[]> getCustomersByBillAmountRange(Double start, Double end);
	
	@Query(value = "{caddress:{$regex:?0}}")
	public List<Customer> getCustomersByRegAddress(String address);
	
	@Query(value = "{billAmt:{$gte:?0, $lte:?1}}", count = true)
	public Integer getCustomersCountByBillAmountRange(Double start, Double end);

	@Query(value="{}", sort = "{billAmt:-1}")
	public List<Customer> getCustomersByBillAmountSorted();

	@Query(value="{billAmt:null}", delete = true)
	public Integer deleteCustomersWithNoBillAmount();
	
	@Query(value="{billAmt:{$gte:?0, $lte:?1}}", exists = true)
	public Boolean areThereCustomersWithBillAmountRang(Double start, Double end);
}
