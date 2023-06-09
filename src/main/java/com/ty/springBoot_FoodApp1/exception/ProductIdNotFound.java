package com.ty.springBoot_FoodApp1.exception;

public class ProductIdNotFound extends RuntimeException{
	
	private String message="id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public ProductIdNotFound(String message) {
		this.message = message;
	}
	
	

}
