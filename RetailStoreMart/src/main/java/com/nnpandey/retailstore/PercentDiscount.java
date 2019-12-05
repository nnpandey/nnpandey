package com.nnpandey.retailstore;

public class PercentDiscount {

	public Item applyDiscount(UserType userType, Item item) {
		// TODO Auto-generated method stub
		Item updatedItem;
		double price = 0;
		if(UserType.EMPLOYEE.equals(userType)) {
			price = item.getUnitPrice()-item.getUnitPrice()*0.3;
			updatedItem = new Item(item.getName(), price, item.getType(),item.getQuantity());
		}else if(UserType.AFFILIATE.equals(userType)) {
			price = item.getUnitPrice()-item.getUnitPrice()*0.1;
			updatedItem = new Item(item.getName(), price, item.getType(),item.getQuantity());
		}else {
			price = item.getUnitPrice()-item.getUnitPrice()*0.05;
			updatedItem = new Item(item.getName(), price, item.getType(),item.getQuantity());
		}
		return updatedItem;
	}

}
