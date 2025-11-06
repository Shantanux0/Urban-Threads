package com.Myntra.clone.clone.service;

import com.Myntra.clone.clone.exception.ProductException;
import com.Myntra.clone.clone.modal.Rating;
import com.Myntra.clone.clone.modal.User;
import com.Myntra.clone.clone.request.RatingRequest;

import java.util.List;



public interface RatingServices {
	
	public Rating createRating(RatingRequest req, User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);

}
