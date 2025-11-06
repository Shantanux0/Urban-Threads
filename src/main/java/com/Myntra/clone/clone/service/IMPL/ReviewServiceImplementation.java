package com.Myntra.clone.clone.service.IMPL;

import java.time.LocalDateTime;
import java.util.List;

import com.Myntra.clone.clone.exception.ProductException;
import com.Myntra.clone.clone.modal.Product;
import com.Myntra.clone.clone.modal.Review;
import com.Myntra.clone.clone.modal.User;
import com.Myntra.clone.clone.repository.ProductRepository;
import com.Myntra.clone.clone.repository.ReviewRepository;
import com.Myntra.clone.clone.request.ReviewRequest;
import com.Myntra.clone.clone.service.ProductService;
import com.Myntra.clone.clone.service.ReviewService;
import org.springframework.stereotype.Service;



@Service
public class ReviewServiceImplementation implements ReviewService {
	
	private ReviewRepository reviewRepository;
	private ProductService productService;
	private ProductRepository productRepository;
	
	public ReviewServiceImplementation(ReviewRepository reviewRepository,ProductService productService,ProductRepository productRepository) {
		this.reviewRepository=reviewRepository;
		this.productService=productService;
		this.productRepository=productRepository;
	}

	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product=productService.findProductById(req.getProductId());
		Review review=new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		
//		product.getReviews().add(review);
		productRepository.save(product);
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		
		return reviewRepository.getAllProductsReview(productId);
	}

}
