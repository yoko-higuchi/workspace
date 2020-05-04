package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//package
import com.example.form.*;

@Controller
@RequestMapping("/ex06")
public class Ex06Controller {
	
	@ModelAttribute
	public Ex06Form setUpForm () {
		return new Ex06Form();
	}

	@RequestMapping("")
	public String index () {
		return "ex-06";
	}
	
	@RequestMapping("/finished")
	public String finished (Ex06Form ex06Form) {
		System.out.println(ex06Form.getName());
		System.out.println(ex06Form.getAge());
		System.out.println(ex06Form.getComment());
		
		return "finished";
	}
}
