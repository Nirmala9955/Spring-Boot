package com.sahu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.service.IEmpMgmtService;

@Component
public class StoredProcedureRunner implements CommandLineRunner {

	@Autowired
	private IEmpMgmtService empMgmtService; 

	@Override
	public void run(String... args) throws Exception {
		empMgmtService.searchEmployeesByDesgs("CLERK", "MANAGER").forEach(System.out::println);
	}

}
