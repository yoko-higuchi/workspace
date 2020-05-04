package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
// package
import com.example.domain.*;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	@RequestMapping("")
	public String index(Model model) {
		List<String> nameList = new ArrayList<>();
		nameList.add("山田");
		nameList.add("鈴木");
		nameList.add("伊藤");
		nameList.add("吉田");
// 		nameList.add("佐藤");
		
		model.addAttribute("nameList", nameList);
		
		
		return "ex-14";
	}
	
}
