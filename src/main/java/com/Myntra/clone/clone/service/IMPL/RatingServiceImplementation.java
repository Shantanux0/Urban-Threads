package com.Myntra.clone.clone.service.IMPL;

import java.time.LocalDateTime;
import java.util.List;

import com.Myntra.clone.clone.exception.ProductException;
import com.Myntra.clone.clone.modal.Product;
import com.Myntra.clone.clone.modal.Rating;
import com.Myntra.clone.clone.modal.User;
import com.Myntra.clone.clone.repository.RatingRepository;
import com.Myntra.clone.clone.request.RatingRequest;
import com.Myntra.clone.clone.service.ProductService;
import com.Myntra.clone.clone.service.RatingServices;
import org.springframework.stereotype.Service;



@Service
public class RatingServiceImplementation implements RatingServices {
	
	private RatingRepository ratingRepository;
	private ProductService productService;
	
	public RatingServiceImplementation(RatingRepository ratingRepository,ProductService productService) {
		this.ratingRepository=ratingRepository;
		this.productService=productService;
	}

	@Override
	public Rating createRating(RatingRequest req, User user) throws ProductException {
		
		Product product=productService.findProductById(req.getProductId());
		
		Rating rating=new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.getAllProductsRating(productId);
	}
	
	

}
