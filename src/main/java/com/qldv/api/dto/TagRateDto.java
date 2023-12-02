package com.qldv.api.dto;
import com.qldv.api.model.TagRate;

public class TagRateDto {
	private Integer id;
	private Integer rate;
	private String content;
	private TagDto tag;
	
	public TagRateDto() {
		// TODO Auto-generated constructor stub
	}
	
	public TagRateDto(TagRate tagRate) {
		id = tagRate.getId();
		rate = tagRate.getRate();
		content = tagRate.getContent();
		tag = new TagDto(tagRate.getTag());
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

	public TagDto getTag() {
		return tag;
	}

	public void setTag(TagDto tag) {
		this.tag = tag;
	}
}
