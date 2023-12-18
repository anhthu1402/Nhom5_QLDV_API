package com.qldv.api.DTO;

import com.qldv.api.Model.User;

public class ReviewUserDto {
	private Integer id;
	private String name;
	private String email;
	private String phone;
	public ReviewUserDto() {
		// TODO Auto-generated constructor stub
	}
	public ReviewUserDto(User user) {
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
