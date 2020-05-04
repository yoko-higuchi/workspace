package com.example.domain;

public class Member {
	String name;
	String age;
	String comment;
	String money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return Integer.parseInt(age);
	}
	public void setAge(Integer age) {
		this.age = String.valueOf(age);
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getMoney() {
		return Integer.parseInt(money);
	}
	public void setMoney(Integer money) {
		this.money = String.valueOf(money);
	}
	
}
