package com.sahu.document;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Player {
	@Id
	private Integer pId;
	private String pName;
	private String pAddress;
	private String country;
	private Set<Sport> sports;
	private Map<String, Medal> medals;
	
	public Player() {
		System.out.println("Player.Player()");
	}

	@Override
	public String toString() {
		return "Player [pId=" + pId + ", pName=" + pName + ", pAddress=" + pAddress + ", country=" + country + "]";
	}
}
