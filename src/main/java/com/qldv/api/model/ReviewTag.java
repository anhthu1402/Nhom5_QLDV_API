package com.qldv.api.model;

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
@Table(name = "user")
public class ReviewTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "review-id")
	private Review review;
	
	@ManyToOne
	@JoinColumn(name = "review-tag-id")
	private TagRate reviewTagRate;
	
	public ReviewTag() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public TagRate getReviewTagRate() {
		return reviewTagRate;
	}

	public void setReviewTagRate(TagRate reviewTagRate) {
		this.reviewTagRate = reviewTagRate;
	}
}
