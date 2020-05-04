package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index () {
		return "exam02";
	}
	
	@RequestMapping("/result-session")
	public String result (String op1, String op2) {
		session.setAttribute("op1", op1);
		session.setAttribute("op2", op2);
		int res = Integer.parseInt(op1) + Integer.parseInt(op2);
		session.setAttribute("res", res);
		
		return "exam02-result";
	}
	
	@RequestMapping("/to-page1")
	public String toPage1 () {
		return "exam02-result";
	}

	@RequestMapping("/to-page2")
	public String toPage2 () {
		return "exam02-result2";
	}
	
}
