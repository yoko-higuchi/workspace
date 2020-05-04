package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Department;
import com.example.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {
	@Autowired
	private DepartmentRepository repository;
	
	public Department load(Integer id) {
		return repository.load(id);
	}
	public List<Department> findAll() {
		return repository.findAll();
	}
	
	public Department save (Department employee) {
		return repository.save(employee);
	}
	
	public void deleteById (Integer id) {
		repository.deleteById(id);
	}


}
