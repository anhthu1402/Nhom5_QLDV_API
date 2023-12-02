package com.qldv.api.dto;

import com.qldv.api.model.Role;
import com.qldv.api.model.User;

public class UserDto {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	private Role role;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		role = user.getRole();
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
