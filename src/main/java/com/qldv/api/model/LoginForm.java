package com.qldv.api.model;

public class LoginForm {
	private String email;
	private String password;
	
	public LoginForm() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginForm(String email, String pw) {
		this.email = email;
		this.password = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
