package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	// 最初のページ
	@RequestMapping("/login")
	public String ex04 () {
		return "ex-04";
	}
	
	// 成功時の処理
	@RequestMapping("/success")
	public String ex04Success (String mail, String password) {
		String trueMail = "abc@gmail.com";
		String truePW = "abc";
		if (mail.equals(trueMail) && password.equals(truePW)) {
			return "success";
		}
		return "redirect:/ex04/failure";
	}
	
	// 失敗時の処理
	@RequestMapping("/failure")
	public String ex04Failure () {
		return "failure";
	}
	
}
