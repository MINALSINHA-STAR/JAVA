package com.kafka.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.restapi.request.OrderStatusEvent;
import com.kafka.restapi.service.OrderStatusProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {


@Autowired
private OrderStatusProducer producer;

@PostMapping("/status")
public String updateOrderStatus(@RequestBody OrderStatusEvent event)  {
	producer.sendOrderStatus(event);
    return "Order status sent to Kafka";
}

}
