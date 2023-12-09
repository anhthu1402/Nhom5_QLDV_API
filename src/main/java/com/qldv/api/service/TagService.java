package com.qldv.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.dto.TagDto;
import com.qldv.api.model.Tag;
import com.qldv.api.model.TagRate;
import com.qldv.api.repository.TagRateRepository;
import com.qldv.api.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	TagRateRepository tagRateRepository;
	
	@Autowired 
	TagRepository tagRepository;
	
	// create tag
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	// add tagDetail
//	public TagDto createTagDetail(Tag tag, TagRate tagRate){
//		
//	}
//	
	// get all tags
	public List<Tag> getAllTags(){
		return tagRepository.findAll();
	}
	
	//get all tag rate
	public List<TagRate> getAllTagRates(){
		return tagRateRepository.findAll();
	}
	//get tag rate by tag 
//	public List<TagRate> getAllTagRateByTagId(Integer tagid){
//		List<TagRate> tagrates = getAllTagRates();
//		List<TagRate> result = new ArrayList<TagRate>();
//		for (TagRate tagrate : tagrates) {
//			if(tagrate.getTag().getId() == tagid) {
//				result.add(tagrate);
//			}
//		}
//		if(result.isEmpty()) {
//			return null;
//		}
//		return result;
//	}
	
	public List<TagDto> getAllTagDetail(){
		List<Tag> tags = getAllTags();
		List <TagDto> result = new ArrayList<TagDto>();
		for (Tag tag : tags) {
			result.add(new TagDto(tag));		
		}
		return result;
	}
	
	
	// get tag by id
	public Tag getTagById(Integer id) {
		Optional<Tag> tag = tagRepository.findById(id);
		if(tag.isPresent()) {
			return tag.get();
		}
		return null;
	}
	
	//update tag
	public Tag updateTag(Integer id, Tag tagDetail) {
		Optional<Tag> tag = tagRepository.findById(id);
		if(tag.isPresent()) {
			Tag t = tag.get();
			t.setName(tagDetail.getName());
			return tagRepository.save(t);
		}
		return tagRepository.save(tagDetail);
	}
	
	//delete tag
	public Boolean deleteTag(Integer id) {
		Optional<Tag> tag = tagRepository.findById(id);
		if(tag.isPresent()) {
			Tag t = tag.get();
			List<TagRate> tagrates = t.getDetails();
			for (TagRate tagrate : tagrates) {
				tagrate.setTag(null);
			}
			tagRepository.delete(t);
			return true;
		}
		return false;
	}
	
}
