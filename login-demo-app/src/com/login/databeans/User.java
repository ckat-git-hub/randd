package com.login.databeans;

public class User {
	
	private String id;
	
	private String name;
	
	private String email;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String idVal,String nameVal,String emailVal) {
		this.id = idVal;
		this.name = nameVal;
		this.email = emailVal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
