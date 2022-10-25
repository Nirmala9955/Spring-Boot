package com.sahu.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IExamResult {
	@Id
	private Integer id;
	private String dob;
	private Float percentage;
	private Integer semester;
}
