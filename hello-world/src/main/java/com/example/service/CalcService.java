package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class CalcService {
	public int add (int num1, int num2) {
		return num1 + num2;
	}

}
