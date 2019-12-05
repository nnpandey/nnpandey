package com.nnpandey.retailstore;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;


public class ShoppingCart {
    private Map<Item, Integer> quantities;
    private User user;

    public ShoppingCart(User user) {
        quantities = new LinkedHashMap<Item, Integer>();
        this.user = user;
    }
    
    public double getTotal() {
    	Discount discount = new Discount();
        double result = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        for (Item each : quantities.keySet()) {
            result += each.priceForQuantity(quantities.get(each));
        }
        
       
        result = discount.applyDiscount(result);
        return Math.round(result*100.0)/100.0;
    }

    
    public void addToCart(Item itemAdded) {
    	Item item = new Item(itemAdded.getName(), itemAdded.getUnitPrice(), itemAdded.getType(),itemAdded.getQuantity());
    	PercentDiscount percentDiscount = new PercentDiscount();
    	if(ItemType.OTHER.equals(itemAdded.getType())) {
    		item = percentDiscount.applyDiscount(user.getType(),itemAdded);
    	}
    	
        quantities.put(item, itemAdded.getQuantity());
    }
}
