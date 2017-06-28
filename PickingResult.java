package com.CommerceHub.IMS;

public class PickingResult {
	//Instance variable aggregation
	private Product product;
	
	//Constructor
	public PickingResult(Product product) {
		this.product = product;
	}
	
	//Method to return the product
	public Product getProduct() {
		return this.product;
	}

}
