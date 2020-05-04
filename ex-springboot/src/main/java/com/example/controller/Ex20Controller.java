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
@RequestMapping("/ex20")
public class Ex20Controller {

	@RequestMapping("")
	public String part() {
		return "/ex20/ex-20-index";
	}
	
	@RequestMapping("/index")
	public String index () {
		return "/ex20/ex-20-index";
	}
}
