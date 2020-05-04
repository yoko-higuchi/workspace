package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Ex17Domain {
	private String name;
	private String mail;
	private String sex;
	private String language;
	private String comment;
	private List<String> hobbyList = new ArrayList<>();
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<String> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
