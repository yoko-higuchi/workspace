package com.example.form;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


public class Ex17Form {
	@NotBlank(message="名前は必須")
	private String name;
	@Size(min=1, max=127, message="1文字以上127文字以内")
	@Email(message="Eメールの形式が不正")
	private String mail;
	@Size(min=1, max=127, message="1文字以上2000文字以内")
	private String comment;
	@NotEmpty(message="1つ以上選択")
	private List<Integer> hobbyList = new ArrayList<>();
	@NotEmpty(message="選択必須")
	private List<Integer> sexList = new ArrayList<>();
	@NotEmpty(message="選択してください")
	private List<Integer> languageList = new ArrayList<>();


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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Integer> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Integer> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public List<Integer> getSexList() {
		return sexList;
	}
	public void setSexList(List<Integer> sexList) {
		this.sexList = sexList;
	}
	public List<Integer> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(List<Integer> languageList) {
		this.languageList = languageList;
	}
}
