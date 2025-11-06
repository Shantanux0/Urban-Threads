package com.Myntra.clone.clone.repository;


import java.util.List;

import com.Myntra.clone.clone.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public List<User> findAllByOrderByCreatedAtDesc();

}
