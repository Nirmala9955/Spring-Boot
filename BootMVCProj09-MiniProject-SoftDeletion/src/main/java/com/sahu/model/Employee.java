package com.sahu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name="boot_emp")
@Data
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='deleted' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'deleted'")
public class Employee {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_no_seq1", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno;
	private String status="active";
}
