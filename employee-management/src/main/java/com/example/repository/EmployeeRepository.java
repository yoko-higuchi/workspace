package com.example.repository;

import com.example.domain.*;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;



@Repository
public class EmployeeRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	

	// id なしの insert
	private SimpleJdbcInsert insert;
	@PostConstruct
	public void init() {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert((JdbcTemplate) template.getJdbcOperations());
		SimpleJdbcInsert withTableName = simpleJdbcInsert.withTableName("employees");
		insert = withTableName.usingGeneratedKeyColumns("id");
	}	

	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER 
	= (rs, i) -> {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setAge(rs.getInt("age"));
		employee.setGender(rs.getString("gender"));
		employee.setDepartmentId(rs.getInt("department_id"));
		return employee;
	};
	
	public Employee load (Integer id) {
		String sql = "SELECT id, name, age, gender, department_id FROM employees WHERE id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);

		return employee;
	}
	
	public List<Employee> findAll() {
		String sql = "SELECT id, name, age, gender, department_id FROM employees ORDER BY age";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}
	
	public Employee save (Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		
		if (employee.getId() == null) {
			Number key = insert.executeAndReturnKey(param);
			employee.setId(key.intValue());
			System.out.println(key + "自動割当");
			
			String insertSql = "INSERT INTO employees(name, age, gender, department_id)"
					+ "VALUES(:name, :age, :gender, :departmentId)";
			template.update(insertSql,param);
		}
		return employee;
	}	
	
	public void deleteById (Integer id) {
		String deleteSql = "DELETE FROM employees WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		template.update(deleteSql,  param);
	}
}
