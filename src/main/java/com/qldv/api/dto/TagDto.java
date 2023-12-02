package com.qldv.api.dto;

import com.qldv.api.model.Tag;

public class TagDto {
	private Integer id;
	private String name;
	
	public TagDto() {
		// TODO Auto-generated constructor stub
	}
	
	public TagDto(Tag tag) {
		id = tag.getId();
		name = tag.getName();
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
}
