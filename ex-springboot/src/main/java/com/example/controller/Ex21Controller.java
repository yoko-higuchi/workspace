package com.example.controller;

import com.example.domain.*;
import com.example.form.*;
import com.example.service.*;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/ex21")
public class Ex21Controller {
	@Autowired
	private Ex21Service ex21Service;
	
	@RequestMapping("/add")
	public String add () {
		int num1 = 2;
		int num2 = 3;
		int resultOfAdd = ex21Service.add(num1, num2);
		
		System.out.println(num1 + " + " + num2 + " = " + resultOfAdd);
		
		return "finished";
	}
	
	@RequestMapping("/sub")
	public String sub () {
		int num1 = 2;
		int num2 = 3;
		int resultOfSub = ex21Service.sub(num1, num2);
		
		System.out.println(num1 + " - " + num2 + " = " + resultOfSub);
		
		return "finished";
		
	}

	@RequestMapping("/multi")
	public String multi () {
		int num1 = 2;
		int num2 = 3;
		int resultOfMulti = ex21Service.multi(num1, num2);
		
		System.out.println(num1 + " * " + num2 + " = " + resultOfMulti);
		
		return "finished";
		
	}
	
	@RequestMapping("/div")
	public String div () {
		int num1 = 2;
		int num2 = 3;
		int resultOfDiv = ex21Service.div(num1, num2);
		
		System.out.println(num1 + " / " + num2 + " = " + resultOfDiv);
		
		return "finished";
		
	}

}
