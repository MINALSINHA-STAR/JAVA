package com.order.shipped.delivered.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.shipped.delivered.entity.OrderEntity;
import com.order.shipped.delivered.exception.OrderNotFoundException;
import com.order.shipped.delivered.repository.OrderRepository;
import com.order.shipped.delivered.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public OrderEntity updateStatus(OrderRequest orderRequest) {
		OrderEntity entity = orderRepository.findById(orderRequest.getOrderId())
				.orElseThrow(() -> 
		 new OrderNotFoundException(
                 "Order not found with id: " + orderRequest.getOrderId()
         )
		 );

		entity.setStatus(orderRequest.getStatus());

		return orderRepository.save(entity);

	}

}
