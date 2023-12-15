package com.qldv.api.Service.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.DTO.TagDto;
import com.qldv.api.DTO.TagRateDto;
import com.qldv.api.Model.Tag;
import com.qldv.api.Model.TagRate;
import com.qldv.api.Repository.TagRateRepository;
import com.qldv.api.Repository.TagRepository;

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
	public TagRate createTagDetail(Integer tagId, TagRateDto tagRateDto ){
		Tag tag = tagRepository.findById(tagId).get();
		TagRate tagRate = new TagRate();
		tagRate.setTag(tag);
		tagRate.setRate(tagRateDto.getRate());
		tagRate.setContent(tagRateDto.getContent());
		return tagRateRepository.save(tagRate);
	}
	
	
	// get all tags
	public List<Tag> getAllTags(){
		return tagRepository.findAll();
	}
	
	//get all tag rate
	public List<TagRate> getAllTagRates(){
		return tagRateRepository.findAll();
	}
	
	//get all tag detail
	public List<TagDto> getAllTagDetail(){
		List<Tag> tags = getAllTags();
		List <TagDto> result = new ArrayList<TagDto>();
		for (Tag tag : tags) {
			result.add(new TagDto(tag));		
		}
		return result;
	}
	
	
	// get tag by id
	public TagDto getTagById(Integer id) {
		Optional<Tag> tag = tagRepository.findById(id);
		if(tag.isPresent()) {
			return new TagDto(tag.get());
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
	
	//update tag detail
	public TagRate updateTagRate(Integer id, TagRate tagRateDetail){
		Optional<TagRate> tagRate = tagRateRepository.findById(id);
		if(tagRate.isPresent()) {
			TagRate t = tagRate.get();
			t.setRate(tagRateDetail.getRate());;
			t.setContent(tagRateDetail.getContent());
			return tagRateRepository.save(t);
		}
		return tagRateRepository.save(tagRateDetail);
	}
	
}
