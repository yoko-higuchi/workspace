package com.example.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index () {
		Integer sum = (Integer)application.getAttribute("sum");
		Integer sumWithTax = (Integer)application.getAttribute("sumWithTax");
		if (sum == null || sumWithTax == null) {
			return "exam03";
		}
		
		return "redirect:/exam03/result";
		
	}
	
	@RequestMapping("/result")
	public String result (Integer goods1, Integer goods2, Integer goods3) {
		int sum = goods1 + goods2 + goods3;
		int numWithTax = (int)((float)sum * 1.1);
		/*
		app.setAttribute("goods1", goods1);
		app.setAttribute("goods2", goods2);
		app.setAttribute("goods3", goods3);
		*/
		
		application.setAttribute("sum", String.format("%,d", sum));
		application.setAttribute("numWithTax", String.format("%,d", numWithTax));
		
		return "exam03-result";
	}

}
