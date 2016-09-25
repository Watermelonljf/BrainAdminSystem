package com.adminsystem.Pojo;

public class User {
	private int userId;
	private String userName;
	private String password;
	private String telephoneNumber;
	private String sex;
	private int age;
	
	public User(int userId, String userName, String password,
			String telephoneNumber, String sex, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.telephoneNumber = telephoneNumber;
		this.sex = sex;
		this.age = age;
	}
	public User() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
