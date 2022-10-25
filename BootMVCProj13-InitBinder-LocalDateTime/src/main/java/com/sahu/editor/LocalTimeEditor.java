package com.sahu.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;

public class LocalTimeEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("LocalTimeEditor.setAsText()");
		//Split the String time value whose pattern is hh:mm 
		String timeContent[] = text.split(":");
		int hours = Integer.parseInt(timeContent[0]);
		int minutes = Integer.parseInt(timeContent[1]);
		//Create LocalTime class object
		LocalTime localTime = LocalTime.of(hours, minutes);
		//set value to model class property
		setValue(localTime);
	}

}
