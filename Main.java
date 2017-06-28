package com.CommerceHub.IMS;

public class Main {

	public static void main(String[] args) {
		Ims inventoryManager= new Ims();
		Location unloading = new Location("unloading");
		Location loading = new Location("loading");
		Location shelf = new Location("shelf");
		Product p1 = new Product("M600B2", 5, unloading);
		Product p2 = new Product("B6002M", 10, loading);
		Product p3 = new Product("CB0034", 2, shelf);
		inventoryManager.addProduct(p1);
		inventoryManager.addProduct(p2);
		inventoryManager.addProduct(p3);
		inventoryManager.viewProductDetails("M600B2");
		inventoryManager.pickProduct("M600B2", 6);
		inventoryManager.viewProductDetails("M600B2");
		inventoryManager.restockProduct("B6002M", 0);
		inventoryManager.viewProductDetails("B6002M");		
	}

}
