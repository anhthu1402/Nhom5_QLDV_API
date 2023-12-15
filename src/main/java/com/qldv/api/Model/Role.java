package com.qldv.api.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	private List<User> listUsers = new ArrayList<User>();
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	
	
}
