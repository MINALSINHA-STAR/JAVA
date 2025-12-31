package com.order.shipped.delivered.exception;

public class OrderNotFoundException  extends RuntimeException{

	public OrderNotFoundException(String message) {
		super(message);
	}

}
