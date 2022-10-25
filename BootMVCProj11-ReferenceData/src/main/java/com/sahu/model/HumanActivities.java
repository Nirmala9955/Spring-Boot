package com.sahu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "HUMAN_ACTIVITIES")
public class HumanActivities {
	@Id
	private String hobbies;
}
