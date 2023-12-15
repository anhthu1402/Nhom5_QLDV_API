package com.qldv.api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking-details")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "booking-id")
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "ticket-id")
	private Ticket ticket;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "total-price")
	private Long totalPrice;
	
	public BookingDetails() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
}
