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
@RequestMapping("/calc")
public class CalcController {
	@Autowired
	private CalcService calcLogic;
	
	@RequestMapping("/add")
	public String add () {
		int num1 = 2;
		int num2 = 3;
		int resultOfAdd = calcLogic.add(num1, num2);
		
		System.out.println(num1 + " + " + num2 + " = " + resultOfAdd);
		
		return "finished";
		
	}
}
