package com.order.shipped.delivered.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.shipped.delivered.entity.OrderEntity;
import com.order.shipped.delivered.request.OrderRequest;
import com.order.shipped.delivered.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	
	@PutMapping("/order/{orderid}")
	public OrderEntity updateStatusRecord(@PathVariable int orderid, @RequestBody OrderRequest orderRequest) {
		
		orderRequest.setOrderId(orderid); 
		OrderEntity update = orderService.updateStatus(orderRequest);
		
		return update;
	}
}
