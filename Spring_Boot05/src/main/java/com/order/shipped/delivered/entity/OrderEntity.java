package com.order.shipped.delivered.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		 private int orderId;
		 private String status;
		 public int getOrderId() {
			return orderId;
		 }
		 public void setOrderId(int orderId) {
			this.orderId = orderId;
		 }
		 public String getStatus() {
			return status;
		 }
		 public void setStatus(String status) {
			this.status = status;
		 }
		 
		
}
