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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/ex17")
public class Ex17Controller {
	@ModelAttribute
	public Ex17Form setUpForm () {
		return new Ex17Form();
	}
	
	@RequestMapping("")
	public String index(Model model) {		
		Map<Integer, String> hobbyMap = new LinkedHashMap<>();
		Map<Integer, String> sexMap = new LinkedHashMap<>();
		Map<Integer, String> languageMap = new LinkedHashMap<>();
		hobbyMap.put(1, "野球");
		hobbyMap.put(2, "サッカー");
		hobbyMap.put(3, "テニス");
		
		sexMap.put(1, "男");
		sexMap.put(2, "女");

		languageMap.put(1, "Java");
		languageMap.put(2, "PHP");
		languageMap.put(3, "Python");
		languageMap.put(4, "Ruby");
		
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("sexMap", sexMap);
		model.addAttribute("languageMap", languageMap);
		
		return "ex17/input";
	}
	
	@RequestMapping("/create")
	public String create (@Validated Ex17Form form, BindingResult result, RedirectAttributes redirirectAttributes, Model model) {
		// エラー処理
		if (result.hasErrors()) {
			return index(model);
		}

		Ex17Domain domain = new Ex17Domain();
		BeanUtils.copyProperties(form, domain);
		
		// 手動コピー : hobby, 言語, 性別
		List<String> hobbyList = new ArrayList<>();
		for (Integer hobbyCode : form.getHobbyList() ) {
			switch (hobbyCode) {
			case 1:
				hobbyList.add("野球");
				break;
			case 2:
				hobbyList.add("サッカー");
				break;
			case 3:
				hobbyList.add("テニス");
				break;
			}
		}
		domain.setHobbyList(hobbyList);
		
		// 性別
		String sex = "";
		for (Integer sexCode : form.getSexList()) {
			switch (sexCode) {
			case 1:
				sex = "男";
				break;
			case 2:
				sex = "女";
				break;
			}
		}
		domain.setSex(sex);

		// 言語
		String language = "";
		for (Integer languageCode : form.getLanguageList()) {
			switch (languageCode) {
			case 1:
				language = "Java";
				break;
			case 2:
				language = "PHP";
				break;
			case 3:
				language = "Python";
				break;
			case 4:
				language = "Ruby";
				break;
			}
		}
		domain.setLanguage(language);

		Ex17Service service = new Ex17Service();
		domain = service.save(domain);

		redirirectAttributes.addFlashAttribute("domain", domain);
		
		return "redirect:/ex17/toresult";
	}
	
	@RequestMapping("/toresult")
	public String toresult () {
		return "ex17/result";
	}
}
