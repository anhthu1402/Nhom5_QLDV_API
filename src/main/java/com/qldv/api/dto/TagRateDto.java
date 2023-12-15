package com.qldv.api.dto;

import com.qldv.api.model.TagRate;

public class TagRateDto {
	private Integer id;
	private Integer rate;
	private String content;
	
	public TagRateDto() {
		// TODO Auto-generated constructor stub
	}
	public TagRateDto(TagRate tagRate) {
		this.id = tagRate.getId();
		this.rate=tagRate.getRate();
		this.content=tagRate.getContent();
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
	
}
