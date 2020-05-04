package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
// package
import com.example.form.*;

@Controller
@RequestMapping("/session-scope")
public class SessionController {
	
	// session
	@Autowired
	private HttpSession session;
		
	@RequestMapping("")
	public String index () {
		return "session-scope-form";
	}
	
	@RequestMapping("/input-name")
	public String inputName (String name) {
		session.setAttribute("name", name);
		return "result-session-scope1";
	}
	
	@RequestMapping("/to-page1")
	public String toPage1 () {
		return "result-session-scope1";
	}
	
	@RequestMapping("/to-page2")
	public String toPage2 () {
		return "result-session-scope2";
	}
	@RequestMapping("/to-page3")
	public String toPage3 () {
		return "result-session-scope3";
	}
	
}
