package com.qldv.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.qldv.api.model.Tag;
import com.qldv.api.model.TagRate;

public class TagDto {
	private Integer id;
	private String name;
	private List<TagRate> details = new ArrayList<TagRate>();
	
	public TagDto() {
		// TODO Auto-generated constructor stub
	}
	
	public TagDto(Tag tag) {
		id = tag.getId();
		name = tag.getName();
		details = tag.getDetails();
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

	public List<TagRate> getDetails() {
		return details;
	}

	public void setDetails(List<TagRate> details) {
		this.details = details;
	}
}
