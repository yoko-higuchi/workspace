package com.example.domain;

import java.util.List;

public class User {
	private Integer id;
	private String name;
	private String mail;
	private String password;
	private List<String> hobbyList;
	
	public Integer getId() {
		return id;
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}
}
