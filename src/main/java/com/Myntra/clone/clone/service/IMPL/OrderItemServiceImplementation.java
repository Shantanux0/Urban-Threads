package com.Myntra.clone.clone.service.IMPL;

import com.Myntra.clone.clone.modal.OrderItem;
import com.Myntra.clone.clone.repository.OrderItemRepository;
import com.Myntra.clone.clone.service.OrderItemService;
import org.springframework.stereotype.Service;


@Service
public class OrderItemServiceImplementation implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	public OrderItemServiceImplementation(OrderItemRepository orderItemRepository) {
		this.orderItemRepository=orderItemRepository;
	}
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

}
