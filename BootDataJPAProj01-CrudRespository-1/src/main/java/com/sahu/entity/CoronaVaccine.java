package com.sahu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Table(name="CORONA_VACCINE_TAB") optional if you want to DB table name same as entity class name
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoronaVaccine implements Serializable {
	@Id //To make property  as singular ID property and to map with singular PK column
	//@Column(name="reg_No") optional if you want to take property name as same as the column name
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long regNo;
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String company;
	@Column(length=20)
	private String country;
	private Double price;
	private Integer requiredDoseCount;
}
