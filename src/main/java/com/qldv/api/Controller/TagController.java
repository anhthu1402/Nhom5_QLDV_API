package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.DTO.TagDto;
import com.qldv.api.DTO.TagRateDto;
import com.qldv.api.Exception.NotFoundException;
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
	public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
		Tag createdTag = tagService.createTag(tag);
        return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
	}
	//create tag detail
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.POST)
	public ResponseEntity<TagRate> createTagDetail(@PathVariable(value = "id") Integer id, @RequestBody TagRateDto tagRateDto) {
		try {
            TagRate tagDetail = tagService.createTagDetail(id, tagRateDto);
            return new ResponseEntity<>(tagDetail, HttpStatus.CREATED);
        } catch (Exception e) {
        	throw new NotFoundException("Tạo tagdetail không thành công. Do không tìm thấy tag có id là: " + id);
        } 
	}
	// get all tags
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<Tag> getAllTags(){
		return tagService.getAllTags();
	}
	// get all tag rates
	@RequestMapping(value = "/tagrates",method = RequestMethod.GET)
	public ResponseEntity<List<TagRate>> getAllTagRates(){
			List<TagRate> tagrates = tagService.getAllTagRates();
		    return new ResponseEntity<>(tagrates, HttpStatus.OK);
	}
	// get all tag rates by tag id
//	@RequestMapping(value = "/{id}/tagrates",method = RequestMethod.GET)
//	public List<TagRate> getAllTagRateByTagId(@PathVariable(value = "id") Integer id){
//		return tagService.getAllTagRateByTagId(id);
//	}
	@RequestMapping(value = "/tagdetail",method = RequestMethod.GET)
	public ResponseEntity<List<TagDto>> getAllTagDetail(){
		List<TagDto> tagdtos = tagService.getAllTagDetail();
	    return new ResponseEntity<>(tagdtos, HttpStatus.OK);
	}
	
	// get tag by id
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<TagDto> getTagById(@PathVariable(value = "id") Integer id){
		TagDto tag = tagService.getTagById(id);
		if(tag == null) {
			 throw new NotFoundException("Không tìm thấy tag có id là: " + id);
		}
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}
	
	//update tag
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Tag> updateTag(@PathVariable(value = "id") Integer id, @RequestBody Tag tagDetail) {
		try {
			Tag tag = tagService.updateTag(id, tagDetail);
			return new ResponseEntity<>(tag, HttpStatus.OK);
		}catch(Exception e) {
			throw new NotFoundException("Không tìm thấy tag có id là: " + id);
		}
        
	}
	
	//delete tag
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Boolean deleteTag(@PathVariable(value = "id") Integer id) {
		return tagService.deleteTag(id);
	}
	
	//update tag detail
	@RequestMapping(value = "/tagrate/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TagRate> updateTagRate(@PathVariable(value = "id") Integer id, @RequestBody TagRate tagRateDetail) {
		try {
			TagRate tagRate = tagService.updateTagRate(id, tagRateDetail);
			return new ResponseEntity<>(tagRate, HttpStatus.OK);
		}catch(Exception e) {
			throw new NotFoundException("Không tìm thấy tag có id là: " + id);
		}
        
	}
	
	
}
