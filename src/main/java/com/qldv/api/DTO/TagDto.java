package com.qldv.api.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qldv.api.Model.Tag;
import com.qldv.api.Model.TagRate;

public class TagDto {
	private Integer id;
	private String name;
	private List<TagRateDto> details = new ArrayList<TagRateDto>();
	
	public TagDto() {
		// TODO Auto-generated constructor stub
	}
	
	public TagDto(Tag tag) {
		id = tag.getId();
		name = tag.getName();
		for (TagRate tagRate : tag.getDetails()) {
			details.add(new TagRateDto(tagRate));
		}
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

	public List<TagRateDto> getDetails() {
		return details;
	}

	public void setDetails(List<TagRateDto> details) {
		this.details = details;
	}
}
