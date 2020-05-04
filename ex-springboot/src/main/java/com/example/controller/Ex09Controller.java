package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// package
import com.example.form.*;

@Controller
@RequestMapping("/ex09")
public class Ex09Controller {
		
	@RequestMapping("")
	public String index () {
		return "ex-09";
	}
	
	@RequestMapping("/success")
	public String successLogin (String mail, String password, Model model) {
		String trueMail = "abc@gmail.com";
		String truePW = "abc";
		if (mail.equals(trueMail) && password.equals(truePW)) {
			model.addAttribute("mail", mail);
			model.addAttribute("password", password);
			
			return "success";
		}
		
		return "redirect:/ex09/failuar";
	}
	
	@RequestMapping("/failuar")
	public String failuarLogin () {
		return "failure";
	}
	
}
