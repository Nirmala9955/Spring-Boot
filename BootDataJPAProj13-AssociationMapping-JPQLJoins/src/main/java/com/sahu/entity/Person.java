package com.sahu.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="OTM_PERSON")
@AllArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pId;
	@NonNull
	@Column(length = 20)
	private String pName;
	@NonNull
	@Column(length = 20)
	private String pAddress;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
	//@JoinColumn(name = "PERSON_ID", referencedColumnName = "P_ID")
	private Set<PhoneNumber> contactDetails;  //For One to Many 
	
	public Person() {
		System.out.println("Person.Person()");
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pAddress=" + pAddress + "]";
	}
	
}
