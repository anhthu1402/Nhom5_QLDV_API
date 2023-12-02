package com.qldv.api.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.model.Review;
import com.qldv.api.model.ReviewTag;
import com.qldv.api.model.TagRate;
import com.qldv.api.repository.ReviewRepository;
import com.qldv.api.repository.ReviewTagRepository;
import com.qldv.api.repository.TagRateRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ReviewTagRepository reviewTagRepository;
	
	@Autowired
	TagRateRepository tagRateRepository;
	
	// create review
	public Review createReview(Review review) {
		Date dateReview = Date.from(Instant.now());
		review.setDateReview(dateReview);
		
		return reviewRepository.save(review);
	}
	
	// add reviewDetail
	public Review addReviewDetail(Integer reviewId, Integer tagRateId) {
		ReviewTag reviewTag = new ReviewTag();
		Review review = reviewRepository.findById(reviewId).get();
		TagRate tagRate = tagRateRepository.findById(tagRateId).get();
		List<ReviewTag> details = review.getDetails();
		if(!details.isEmpty()) {
			for (ReviewTag detail : details) {
				if(detail.getTagRate().getTag().getId() == tagRate.getTag().getId()) {
					return review;
				}
			}
		}
		reviewTag.setReview(review);
		reviewTag.setTagRate(tagRate);
		reviewTagRepository.save(reviewTag);
		
		review.addReviewDetail(reviewTag);
		reviewRepository.save(review);
		return review;
	}
	
	public List<Review> getAllReviews(){
		return reviewRepository.findAll();
	}
	
	public Review getReviewById(Integer id) {
		Optional<Review> review = reviewRepository.findById(id);
		if(review.isPresent()) {
			return review.get();
		}
		return null;
	}
	
	public List<Review> getAllReviewsByUserId(Integer userId){
		List<Review> list = getAllReviews();
		List<Review> result = new ArrayList<Review>();
		for (Review review : list) {
			if(review.getUser().getId() == userId) {
				result.add(review);
			}
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	
}
