package com.qldv.api.dto;

import com.qldv.api.model.User;

public class UserDto {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
