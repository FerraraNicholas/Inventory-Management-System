package com.CommerceHub.IMS;

public class RestockingResult {
	//Instance variable aggregation
	private Product product;
	
	//Constructor
	public RestockingResult(Product product) {
		this.product = product;
	}
	
	//Method to return the product
	public Product getProduct() {
		return this.product;
	}

}
