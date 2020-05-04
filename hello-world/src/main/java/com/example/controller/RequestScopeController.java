package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// package
import com.example.form.*;

@Controller
@RequestMapping("/request-scope")
public class RequestScopeController {
		
	@RequestMapping("")
	public String index () {
		return "request-scope-form";
	}
	
	@RequestMapping("/input-name")
	public String inputName (String name, Model model) {
		model.addAttribute("name", name);
		return "result-request-scope";
	}
	
}
