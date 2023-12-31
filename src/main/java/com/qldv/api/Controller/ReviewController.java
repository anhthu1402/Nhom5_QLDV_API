package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.DTO.ReviewDto;
import com.qldv.api.DTO.ReviewStatistics;
import com.qldv.api.Model.Review;
import com.qldv.api.Service.Implement.ReviewService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/reviews")
public class ReviewController {
	@Autowired 
	ReviewService reviewService;
	
	// create review
	@RequestMapping(value = "/user/{user-id}", method = RequestMethod.POST)
	public ReviewDto createReview(@RequestBody Review review, @PathVariable(value = "user-id") Integer userId) {
		return reviewService.createReview(review, userId);
	}
	// get all reviews
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<ReviewDto> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	// add reviewDetail
	@RequestMapping(value = "/{review-id}/tag-rate/{tag-rate-id}", method = RequestMethod.PUT)
	public ReviewDto addReviewDetail(@PathVariable(value = "review-id") Integer reviewId, @PathVariable(value = "tag-rate-id") Integer tagRateId) {
		return reviewService.addReviewDetail(reviewId, tagRateId);
	}
	
	// get review by user id
	@RequestMapping(value = "/user/{user-id}", method = RequestMethod.GET)
	public List<ReviewDto> getAllReview(@PathVariable(value = "user-id") Integer userId){
		return reviewService.getAllReviewsByUserId(userId);
	}
	
	// review statistics 
	@RequestMapping(value = "/statistic/tag/{tag-id}", method = RequestMethod.GET)
	public ReviewStatistics getReviewStatisticByTagId(@PathVariable(value = "tag-id") Integer tagId){
		return reviewService.getReviewStatisticByTagId(tagId);
	}
	
	// get list review by filter
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public List<ReviewDto> getListReviewByFilter(@RequestParam(value = "tag-id", required = false) Integer tagId, @RequestParam(value = "rate", required = false) Integer rate){
		return reviewService.getListReviewByFilter(tagId, rate);
	}
	
	// get all review statistic
	@RequestMapping(value = "/statistic", method = RequestMethod.GET)
	public List<ReviewStatistics> getAllReviewStatistic(){
		return reviewService.getAllReviewStatistic();
	}
	
	// get review by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ReviewDto getReviewById(@PathVariable(value = "id") Integer id) {
		return reviewService.getReviewById(id);
	}
	
	
}
