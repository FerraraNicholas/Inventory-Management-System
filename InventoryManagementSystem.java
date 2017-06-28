package com.CommerceHub.IMS;


public interface InventoryManagementSystem {
	/**
	* Deduct 'amountToPick' of given 'productId' from inventory.
	* @param productId the ID of the product to pick
	* @param amountToPick The quantity of the product to pick
	* @return TODO: to be implemented
	*/
	PickingResult pickProduct(String productId, int amountToPick);
	/**
	* Deduct 'amountToRestock' of given 'productId' from inventory.
	* @param productId the ID of the product to restock
	* @param amountToRestock The quantity of the product to restock
	* @return TODO: to be implemented
	*/
	RestockingResult restockProduct(String productId, int amountToRestock);

}