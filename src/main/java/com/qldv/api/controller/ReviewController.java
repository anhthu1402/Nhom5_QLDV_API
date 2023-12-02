package com.qldv.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.model.Review;
import com.qldv.api.service.ReviewService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/reviews")
public class ReviewController {
	@Autowired 
	ReviewService reviewService;
	
	// create review
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Review createReview(@RequestBody Review review) {
		return reviewService.createReview(review);
	}
	// get all reviews
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews();
	}
	
	// add reviewDetail
	@RequestMapping(value = "/details/review-id/{review-id}/tag-rate-id/{tag-rate-id}", method = RequestMethod.PUT)
	public Review addReviewDetail(@PathVariable(value = "review-id") Integer reviewId, @PathVariable(value = "tag-rate-id") Integer tagRateId) {
		return reviewService.addReviewDetail(reviewId, tagRateId);
	}
	
}
