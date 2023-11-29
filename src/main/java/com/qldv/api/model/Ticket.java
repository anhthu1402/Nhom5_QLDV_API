package com.qldv.api.model;

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
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "price")
	private Long price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ticket")
	private List<BookingDetails> listBookingDetails = new ArrayList<BookingDetails>();
	
	public Ticket() {
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public List<BookingDetails> getListBookingDetails() {
		return listBookingDetails;
	}

	public void setListBookingDetails(List<BookingDetails> listBookingDetails) {
		this.listBookingDetails = listBookingDetails;
	}
}
