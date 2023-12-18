package com.qldv.api.Service.Implement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.DTO.ReviewDto;
import com.qldv.api.DTO.ReviewStatistics;
import com.qldv.api.Model.Review;
import com.qldv.api.Model.ReviewTag;
import com.qldv.api.Model.Tag;
import com.qldv.api.Model.TagRate;
import com.qldv.api.Repository.ReviewRepository;
import com.qldv.api.Repository.ReviewTagRepository;
import com.qldv.api.Repository.TagRateRepository;
import com.qldv.api.Repository.TagRepository;
import com.qldv.api.Repository.UserRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	ReviewTagRepository reviewTagRepository;
	
	@Autowired
	TagRateRepository tagRateRepository;
	
	@Autowired 
	TagRepository tagRepository;
	
	@Autowired
	UserRepository userRepository;
	
	// create review
	public ReviewDto createReview(Review review, Integer userId) {
		Date dateReview = Date.from(Instant.now());
		review.setDateReview(dateReview);
		review.setUser(userRepository.findById(userId).get());
		reviewRepository.save(review);
		return new ReviewDto(review);
	}
	
	// add reviewDetail
	public ReviewDto addReviewDetail(Integer reviewId, Integer tagRateId) {
		ReviewTag reviewTag = new ReviewTag();
		Review review = reviewRepository.findById(reviewId).get();
		TagRate tagRate = tagRateRepository.findById(tagRateId).get();
		List<ReviewTag> details = review.getDetails();
		if(!details.isEmpty()) {
			for (ReviewTag detail : details) {
				if(detail.getTagRate().getTag().getId() == tagRate.getTag().getId()) {
					return new ReviewDto(review);
				}
			}
		}
		reviewTag.setReview(review);
		reviewTag.setTagRate(tagRate);
		reviewTagRepository.save(reviewTag);
		
		review.addReviewDetail(reviewTag);
		reviewRepository.save(review);
		return new ReviewDto(review);
	}
	
	// get all reviews
	public List<ReviewDto> getAllReviews(){
		List<Review> list = reviewRepository.findAll();
		List<ReviewDto> result = new ArrayList<ReviewDto>();
		for (Review review : list) {
			ReviewDto reviewDto = new ReviewDto(review);
			result.add(reviewDto);
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	// get review by id
	public ReviewDto getReviewById(Integer id) {
		Optional<Review> review = reviewRepository.findById(id);
		if(review.isPresent()) {
			return new ReviewDto(review.get());
		}
		return null;
	}
	
	// get review by user id
	public List<ReviewDto> getAllReviewsByUserId(Integer userId){
		List<ReviewDto> list = getAllReviews();
		List<ReviewDto> result = new ArrayList<ReviewDto>();
		for (ReviewDto review : list) {
			if(review.getUser().getId() == userId) {
				result.add(review);
			}
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	// get list review by filter
	public List<ReviewDto> getListReviewByFilter(Integer tagId, Integer rate){
		List<ReviewDto> list = getAllReviews();
		List<ReviewDto> result = new ArrayList<ReviewDto>();
		if(tagId != null) {
			for (ReviewDto review : list) {
				List<ReviewTag> reviewTags = review.getDetails();
				for (ReviewTag reviewTag : reviewTags) {
					TagRate tagRate = reviewTag.getTagRate();
					if(tagRate.getTag().getId() == tagId) {
						if(rate != null) {
							if(tagRate.getRate() == rate) {
								result.add(review);
							}
						}
						else result.add(review);
					}
				}
			}
			if(result.isEmpty()) {
				return null;
			}
			return result;
		}
		else {
			if(rate != null) {
				for (ReviewDto review : list) {
					if(review.getRate() == rate) {
						result.add(review);
					}
				}
				if(result.isEmpty()) {
					return null;
				}
				return result;
			}
			return list;
		}
	}
	
	// get ReviewStatistic by tag id and rate
	public ReviewStatistics getReviewStatistic(Integer tagId, Integer rate) {
		List<TagRate> list = tagRateRepository.findAll();
		for (TagRate tagRate : list) {
			if(tagRate.getTag().getId() == tagId) {
				if(tagRate.getRate() == rate) {
					return new ReviewStatistics(tagRate);
				}
			}
		}
		return null;
	}
	
	// review statistics by tag id
	public ReviewStatistics getReviewStatisticByTagId(Integer tagId){
		List<ReviewDto> list = getAllReviews();
		Integer count = 0, rate = 0;
		for (ReviewDto review : list) {
			List<ReviewTag> reviewTags = review.getDetails();
			for (ReviewTag reviewTag : reviewTags) {
				TagRate tagRate = reviewTag.getTagRate();
				if(tagRate.getTag().getId() == tagId) {
					count++;
					rate += tagRate.getRate();
				}
			}
		}
		Double average = (rate*1.0)/count;
		ReviewStatistics revSta = getReviewStatistic(tagId, (int) Math.round(average));
		if(revSta != null) {
			revSta.setCount(count);
			return revSta;
		}
		return null;
	}
	
	// get all review statistic
	public List<ReviewStatistics> getAllReviewStatistic(){
		List<Tag> listTag = tagRepository.findAll();
		List<ReviewStatistics> result = new ArrayList<ReviewStatistics>();
		for (Tag tag : listTag) {
			ReviewStatistics reviewStatistics = getReviewStatisticByTagId(tag.getId());
			result.add(reviewStatistics);
		}
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
}
