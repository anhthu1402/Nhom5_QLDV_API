package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.DTO.TagDto;
import com.qldv.api.DTO.TagRateDto;
import com.qldv.api.Model.Tag;
import com.qldv.api.Model.TagRate;
import com.qldv.api.Service.Implement.TagService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/tags")
public class TagController {
	@Autowired 
	TagService tagService;

	// create tag
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Tag createTag(@RequestBody Tag tag) {
		return tagService.createTag(tag);
	}
	//create tag detail
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.POST)
	public TagRate createTagDetail(@PathVariable(value = "id") Integer id, @RequestBody TagRateDto tagRateDto) {
		return tagService.createTagDetail(id, tagRateDto);
	}
	// get all tags
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<Tag> getAllTags(){
		return tagService.getAllTags();
	}
	// get all tag rates
	@RequestMapping(value = "/tagrates",method = RequestMethod.GET)
	public List<TagRate> getAllTagRates(){
		return tagService.getAllTagRates();
	}
	// get all tag rates by tag id
//	@RequestMapping(value = "/{id}/tagrates",method = RequestMethod.GET)
//	public List<TagRate> getAllTagRateByTagId(@PathVariable(value = "id") Integer id){
//		return tagService.getAllTagRateByTagId(id);
//	}
	@RequestMapping(value = "/tagdetail",method = RequestMethod.GET)
	public List<TagDto> getAllTagDetail(){
		return tagService.getAllTagDetail();
	}
	
	// get tag by id
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public TagDto getTagById(@PathVariable(value = "id") Integer id){
		return tagService.getTagById(id);
	}
	
	//update tag
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Tag updateTag(@PathVariable(value = "id") Integer id, @RequestBody Tag tagDetail) {
		return tagService.updateTag(id, tagDetail);
	}
	
	//delete tag
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Boolean deleteTag(@PathVariable(value = "id") Integer id) {
		return tagService.deleteTag(id);
	}
	
	//update tag detail
	@RequestMapping(value = "/tagrate/{id}", method = RequestMethod.PUT)
	public TagRate updateTagRate(@PathVariable(value = "id") Integer id, @RequestBody TagRate tagRateDetail) {
		return tagService.updateTagRate(id, tagRateDetail);
	}
	
	
}
