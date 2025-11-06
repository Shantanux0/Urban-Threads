package com.Myntra.clone.clone.service;


import com.Myntra.clone.clone.exception.ProductException;
import com.Myntra.clone.clone.modal.Cart;
import com.Myntra.clone.clone.modal.CartItem;
import com.Myntra.clone.clone.modal.User;
import com.Myntra.clone.clone.request.AddItemRequest;

public interface CartService {
	
	public Cart createCart(User user);
	
	public CartItem addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
