package com.nnpandey.retailstore;

/*
 * Class for actual product items
 */
public class Item {

    private final String name;
    private final double unitPrice;
    private final ItemType type;
    private final int quantity;

    public Item(String name, double unitPrice, ItemType type, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.type = type;
		this.quantity = quantity;
	}

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public double priceForQuantity(int quantity) {
        return unitPrice * quantity;
    }
    
    public ItemType getType() {
    	return type;
    }

	public int getQuantity() {
		return quantity;
	}
    
    
}
