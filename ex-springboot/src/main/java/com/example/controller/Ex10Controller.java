package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
// package
import com.example.form.*;
import com.example.domain.*;

@Controller
@RequestMapping("/ex10")
public class Ex10Controller {
	
	// session
	@Autowired
	private HttpSession session;
	
	// ?????
	public User setUpUser () {
		return new User();
	}
		
	@RequestMapping("")
	public String index () {
		return "ex-10";
	}
	
	@RequestMapping("/ex-10-session")
	public String ex10Session (User user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		System.out.println(user.getComment());

		session.setAttribute("name", user.getName());
		session.setAttribute("age", user.getAge());
		session.setAttribute("comment", user.getComment());
		return "ex-10-output";
	}
	
	@RequestMapping("/to-page1")
	public String toPage1 () {
		return "ex-10-output";
	}
	@RequestMapping("/to-page2")
	public String toPage2 () {
		return "ex-10-output2";
	}
	
	
}
