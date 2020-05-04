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
@RequestMapping("/factorial")
public class FactorialController {
	@Autowired
	private FactorialService factorialService;
	
	@RequestMapping("/view-result")
	public String viewResult () {
		int num = 5;
		int res = factorialService.getFactorial(num);
		System.out.println(num + "の２乗は " + res);
		
		return "finished";
	}
}
