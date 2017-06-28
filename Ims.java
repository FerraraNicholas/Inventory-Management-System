package com.CommerceHub.IMS;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Ims implements InventoryManagementSystem {
	//Instance variables, use Concurrent Hash Map for thread-safety 
	private Map<String, Product> products;
	private Map<String, Location> locations;
	
	//Constructor
	public Ims(){
		this.products = new ConcurrentHashMap<String, Product>();
		this.locations = new ConcurrentHashMap<String, Location>();
	}
	
	//Method to add a product to the hashmap
	public Ims addProduct(Product product) {
		products.put(product.getProductId(), product);
		return this;
	}
	
	//Method that returns the hashmap of products
	public Map<String, Product> getProducts(){
		return this.products;
	}
	
	//Method that adds a location 
	public Ims addLocation(Location location) {
		locations.put(location.getName(), location);
		return this;
	}
	
	//Method that returns the locations
	public Map<String, Location> getLocations() {
		return this.locations;
	}
	
	//Method that prints the details based on a product Id
	public void viewProductDetails(String productId) {
		Product product = this.products.get(productId);
		System.out.println(product.getProductId() + " has " + product.getProductLevel() + " inventory left. The location is at "
				+ product.getLocation().getName());	
	}
	
	@Override
	// Implemented from the interface
	//Method picks a product and based on Id deducts a requested amount of quantity
	public PickingResult pickProduct(String productId, int amountToPick) {
		if (productId == null) {
			System.err.println("!---ERROR - Product id is null- ERROR---!");
			return null;	
		}
		if (products.get(productId) == null) {
			System.err.println("!---ERROR - Product id does not exists- ERROR---!");
			return null;	
		}
		Product product = products.get(productId);
		if(amountToPick > product.getProductLevel()) {
			System.err.println("!---ERROR - The quanity requested exceeds the level in stock - ERROR---!");
			return null;
		} else {
			synchronized (this) {
				product.removeAmount(amountToPick);	
				PickingResult result = new PickingResult(product);
				return result;
			}
		}
	}

	@Override
	//Implemented from interface
	//Method picks a product based on id to add quantity 
	public RestockingResult restockProduct(String productId, int amountToRestock) {
		if (productId == null) {
			System.err.println("!---ERROR - Product id is null- ERROR---!");
			return null;	
		}
		if (products.get(productId) == null) {
			System.err.println("!---ERROR - Product id does not exists- ERROR---!");
			return null;	
		}
		synchronized (this) {
			Product product = products.get(productId);
			product.addAmount(amountToRestock);
			RestockingResult result = new RestockingResult(product);
			return result;	
		}
	}

}
