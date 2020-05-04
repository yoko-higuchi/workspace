package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Department;
import com.example.domain.Employee;

@Repository
public class DepartmentRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Department> EMPLOYEE_ROW_MAPPER 
	= (rs, i) -> {
		Department department = new Department();
		department.setId(rs.getInt("id"));
		department.setName(rs.getString("name"));
		return department;
	};

	
	public Department load (Integer id) {
		String sql = "SELECT id, name FROM departments WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Department department = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

		return department;
	}
	
	public List<Department> findAll() {
		String sql = "SELECT id, name FROM departments ORDER BY id";
		System.out.println(sql);

		List<Department> departmentList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return departmentList;
	}
	
	public Department save (Department department) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(department);
		
		if (department.getId() == null) {
			/*
			Number key = insert.executeAndReturnKey(param);
			employee.setId(key.intValue());
			System.out.println(key + "自動割当");
			*/
			String insertSql = "INSERT INTO employees(name)"
					+ "VALUES(:name)";
			template.update(insertSql,param);
		}
		return department;
	}
	
	public void deleteById (Integer id) {
		String deleteSql = "DELETE FROM departments WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		template.update(deleteSql,  param);
	}
}
