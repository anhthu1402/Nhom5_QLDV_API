package com.qldv.api.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "rate")
	private Integer rate;
	
	@Column(name = "date")
	private Date dateReview;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "review")
	private List<ReviewTag> details = new ArrayList<ReviewTag>();
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Date getDateReview() {
		return dateReview;
	}

	public void setDateReview(Date dateReview) {
		this.dateReview = dateReview;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ReviewTag> getDetails() {
		return details;
	}

	public void setDetails(List<ReviewTag> details) {
		this.details = details;
	}
	
	public void addReviewDetail(ReviewTag reviewTag) {
		details.add(reviewTag);
	}
	
	public void removeReviewDetail(ReviewTag reviewTag) {
		details.remove(reviewTag);
	}
}
