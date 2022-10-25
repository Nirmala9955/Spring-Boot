package com.sahu.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Setter
@Getter
public class Medal {
	@Id
	private String id;
	private MedalType type;
	private String sportName;
	private String eventName;
	private Double priceMoney;
	
	public Medal() {
		System.out.println("Medal.Medal()");
	}

	@Override
	public String toString() {
		return "Medal [id=" + id + ", type=" + type + ", sportName=" + sportName + ", eventName=" + eventName
				+ ", priceMoney=" + priceMoney + "]";
	}	
}
