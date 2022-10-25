package com.sahu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sahu.service.IPersonMgmtService;

@Component
public class AssociationJoinTestRunner implements CommandLineRunner {
	
	@Autowired
	private IPersonMgmtService personMgmtService;

	@Override
	public void run(String... args) throws Exception {
		personMgmtService.fetchDataByJoinUsingParent().forEach(row->{
			for (Object val : row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
	}

}
