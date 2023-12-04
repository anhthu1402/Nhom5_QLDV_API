package com.qldv.api.dto;

import com.qldv.api.model.TagRate;

public class ReviewStatistics {
	private Integer count;
	private TagRate tagRate;
	
	public ReviewStatistics() {
		// TODO Auto-generated constructor stub
	}
	
	public ReviewStatistics(TagRate tagRate) {
		this.tagRate = tagRate;
	}
	
	public ReviewStatistics(Integer count, TagRate tagRate) {
		this.count = count;
		this.tagRate = tagRate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public TagRate getTagRate() {
		return tagRate;
	}

	public void setTagRate(TagRate tagRate) {
		this.tagRate = tagRate;
	}
}
