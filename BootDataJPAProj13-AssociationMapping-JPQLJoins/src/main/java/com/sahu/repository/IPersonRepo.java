package com.sahu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahu.entity.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer> {
	//@Query("SELECT p.pId, p.pName, p.pAddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p INNER JOIN p.contactDetails ph")
	//@Query("SELECT p.pId, p.pName, p.pAddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p RIGHT JOIN p.contactDetails ph")
	//@Query("SELECT p.pId, p.pName, p.pAddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p LEFT JOIN p.contactDetails ph")
	@Query("SELECT p.pId, p.pName, p.pAddress, ph.regNo, ph.phoneNo, ph.provider, ph.type FROM Person p FULL JOIN p.contactDetails ph")
	public List<Object[]> fetchDataUsingJoinsByParent();
}
