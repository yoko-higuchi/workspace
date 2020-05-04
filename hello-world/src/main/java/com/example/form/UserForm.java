package com.example.form;

import java.util.List;
import javax.validation.constraints.*;

public class UserForm {
	@NotBlank(message="名前は必須")
	private String name;
	@Size(min=1, max=127, message="1文字以上127文字以内")
	@Email(message="Eメールの形式が不正")
	private String mail;
	@Size(min=1, max=127, message="1文字以上127文字以内")
	private String password;
	@NotEmpty(message="1つ以上選択")
	private List<Integer> hobbyList;
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
	public List<Integer> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Integer> hobbyList) {
		this.hobbyList = hobbyList;
	}
}
