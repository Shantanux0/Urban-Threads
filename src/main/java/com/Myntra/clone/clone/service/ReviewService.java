package com.Myntra.clone.clone.service;

import com.Myntra.clone.clone.exception.ProductException;
import com.Myntra.clone.clone.modal.Review;
import com.Myntra.clone.clone.modal.User;
import com.Myntra.clone.clone.request.ReviewRequest;

import java.util.List;



public interface ReviewService {

	public Review createReview(ReviewRequest req, User user) throws ProductException;
	
	public List<Review> getAllReview(Long productId);
	
	
}
