package com.qldv.api.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone")
	private String phone;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Booking> listBookings = new ArrayList<Booking>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Review> listReviews = new ArrayList<Review>();
	
	public User() {
		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Booking> getListBookings() {
		return listBookings;
	}

	public void setListBookings(List<Booking> listBookings) {
		this.listBookings = listBookings;
	}

	public List<Review> getListReviews() {
		return listReviews;
	}

	public void setListReviews(List<Review> listReviews) {
		this.listReviews = listReviews;
	}
}
