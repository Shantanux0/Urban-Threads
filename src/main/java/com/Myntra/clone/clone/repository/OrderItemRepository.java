package com.Myntra.clone.clone.repository;

import com.Myntra.clone.clone.modal.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
