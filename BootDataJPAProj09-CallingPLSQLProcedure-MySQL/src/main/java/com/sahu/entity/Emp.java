package com.sahu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empno;
	@Column(length=20)
	private String ename;
	@Column(length=20)
	private String job;
	private Integer sal;	
}
