package com.order.shipped.delivered.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.shipped.delivered.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{


}
