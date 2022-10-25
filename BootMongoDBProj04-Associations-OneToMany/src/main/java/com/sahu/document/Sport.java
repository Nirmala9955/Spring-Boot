package com.sahu.document;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Sport {
	@Id
	private Long id;
	private String name;
	private  Boolean teamSport;
	private Boolean isOlympicSport;
	private String[] kitItems;
	
	public Sport() {
		System.out.println("Sport.Sport()");
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", teamSport=" + teamSport + ", isOlympicSport=" + isOlympicSport
				+ ", kitItems=" + Arrays.toString(kitItems) + "]";
	}
}
