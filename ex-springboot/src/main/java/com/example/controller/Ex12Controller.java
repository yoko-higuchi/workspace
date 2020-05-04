package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
// package
import com.example.domain.*;

@Controller
@RequestMapping("/ex12")
public class Ex12Controller {
	
	// ?????
	public Member setUpUser () {
		return new Member();
	}

	
	@RequestMapping("")
	public String index () {
		return "ex-12-register-member";
	}
	
	@RequestMapping("/input")
	//public String ex10Session (String name, String age, String money, String comment, Model model) {
	public String ex10Session (Member member, Model model) {
		// model.addAttribute("member", member);
		Member outMember = new Member();
		outMember.setName(member.getName());
		outMember.setAge(member.getAge());
		outMember.setMoney(member.getMoney());
		outMember.setComment(member.getComment());
		model.addAttribute("member", outMember);
		
		return "ex-12-register-member-output";
	}
	
	@RequestMapping("/output")
	public String output () {
		return "ex-12-register-member-output";
	}
	
	
}
