package com.sahu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOT_MARRIAGE_SEEKER_INFO")
public class MarriageSeekerInfo {
	@Id
	@GeneratedValue
	private Integer profileId;
	@Column(length = 20)
	private String ProfileName;
	@Column(length = 10)
	private String gender;
	@Column(length = 200)
	private String resumePath;
	@Column(length = 200)
	private String photoPath;
}
