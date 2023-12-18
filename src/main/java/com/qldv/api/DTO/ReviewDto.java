package com.qldv.api.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qldv.api.Model.Review;
import com.qldv.api.Model.ReviewTag;

public class ReviewDto {
	private Integer id;
	private String content;
	private Integer rate;
	private Date dateReview;
	private ReviewUserDto user;
	private List<ReviewTag> details = new ArrayList<ReviewTag>();
	public ReviewDto() {
		// TODO Auto-generated constructor stub
	}
	public ReviewDto(Review review) {
		id = review.getId();
		content = review.getContent();
		rate = review.getRate();
		dateReview = review.getDateReview();
		user = new ReviewUserDto(review.getUser());
		details = review.getDetails();
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
	public ReviewUserDto getUser() {
		return user;
	}
	public void setUser(ReviewUserDto user) {
		this.user = user;
	}
	public List<ReviewTag> getDetails() {
		return details;
	}
	public void setDetails(List<ReviewTag> details) {
		this.details = details;
	}
}
