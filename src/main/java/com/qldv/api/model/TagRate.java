package com.qldv.api.model;

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
@Table(name = "tag-rate")
public class TagRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "rate")
	private Integer rate;
	
	@Column(name = "content")
	private String content;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tag-id")
	private Tag tag;
	
	@JsonIgnore
	@OneToMany(mappedBy = "reviewTagRate")
	private List<ReviewTag> reviewTagRate = new ArrayList<ReviewTag>();
	
	public TagRate() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<ReviewTag> getReviewTagRate() {
		return reviewTagRate;
	}

	public void setReviewTagRate(List<ReviewTag> reviewTagRate) {
		this.reviewTagRate = reviewTagRate;
	}
}
