package com.CommerceHub.IMS;

public class Product {
	//Instance variables tracking the location and level of product
	private String productId;
	private int productLevel;
	private Location location;
	
	
	//Constructor setting the level and location of the product
	public Product(String productId, int productLevel, Location location) {
		this.productId = productId;
		this.productLevel = productLevel;
		this.location = location;
	}
	
	//Mutator to set the product Id
	public void setProductId(String newId) {
		this.productId = newId;
	}
	
	//Method to return the product Id
	public String getProductId(){
		return this.productId;
	}
	
	//Method to return the level or product
	public int getProductLevel() {
		return this.productLevel;
	}
	
	//Method that removes a specified amount from inventory
	public void removeAmount(int amount) {
		this.productLevel -= amount;
	}
	
	//Method that add a specified amount to the inventory
	public void addAmount(int amount) {
		this.productLevel += amount;
	}
	
	//Method to return the location
	public Location getLocation() {
		return this.location;
	}
	
	@Override 
	//Override of ToString method for product
	public String toString() {
		return "Product Id: " + productId + "\nProduct Level: " + productLevel;
	}

}
