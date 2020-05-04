package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Department;
import com.example.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	@RequestMapping("/execute")
	public String execute() {
		Department department = new Department();
		department.setName("営業部");
		department.setId(1);
		service.save(department);
		
		Department department2 = service.load(3);
		System.out.println(department2);
		service.deleteById(3);
		service.findAll().forEach(System.out::println);
		
		return "finished";
	}

}
