package com.Myntra.clone.clone.service;

import com.Myntra.clone.clone.exception.UserException;
import com.Myntra.clone.clone.modal.User;

import java.util.List;



public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	public List<User> findAllUsers();

}
