package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class FactorialService {
	public int getFactorial (int num) {
		return num * num;
	}
}
