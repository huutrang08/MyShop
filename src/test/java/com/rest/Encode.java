package com.rest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encode {
	 public static void main(String[] args) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			System.out.println(passwordEncoder.encode("admin"));
		}
}
