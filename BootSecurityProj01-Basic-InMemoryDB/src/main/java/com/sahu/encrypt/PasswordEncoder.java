package com.sahu.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password1 = encoder.encode("rani");
		String password2 = encoder.encode("ramesh123");
		System.out.println(password1);
		System.out.println(password2);
	}
	
}
