package com.example.controller;

import com.example.domain.*;
import com.example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeContoroller {
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/execute")
	public String execute() {
		Employee employee = new Employee();
		employee.setName("山田太郎");
		employee.setAge(20);
		employee.setGender("男");
		employee.setDepartmentId(1);
		service.save(employee);
		
		Employee employee2 = service.load(3);
		System.out.println(employee2);
		service.deleteById(3);
		service.findAll().forEach(System.out::println);
		
		return "finished";
	}
}
