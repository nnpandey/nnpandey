package com.nnpandey.retailstore;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main (String[] args)
    {
    	User user = fetchUser();
    	List<Item>cartItems = fetchCartItems();
        ShoppingCart cart = new ShoppingCart(user);
        for(Item item:cartItems) {
        	cart.addToCart(item);
        	
        }
        
        System.out.println("Cart Total  "+cart.getTotal());        
    }

	private static List<Item> fetchCartItems() {
		// TODO Auto-generated method stub
		int moreItems = 1;
		List<Item>cartItems = new ArrayList<Item>();
		Item item = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Adding items to cart");
		while(moreItems==1) {
			
			System.out.println("Enter item name");
			String itemName = scanner.next();
			System.out.println("Enter quantity");
			int quantity  = scanner.nextInt();
			System.out.println("Enter unit price");
			double unitPrice = scanner.nextDouble();
			System.out.println("Enter item type");
			System.out.println("Enter 1 for GROCERY");
			System.out.println("Enter 2 for Others");
			int type = scanner.nextInt();
			if(type==1) {
				item = new Item(itemName, unitPrice, ItemType.GROCERY,quantity);
			}else {
				item = new Item(itemName, unitPrice, ItemType.OTHER,quantity);
			}
			cartItems.add(item);
			System.out.println();
			System.out.println("Enter 1 to add new items");
			System.out.println("Enter 0 to stop adding");
			moreItems = scanner.nextInt();
			
		}
		return cartItems;
	}

	private static User fetchUser() {
		Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter Customer Name ");
    	String cname = scanner.nextLine();
    	System.out.println("Enter User Type ");
    	System.out.println("Enter 1 for Employee");
    	System.out.println("Enter 2 for Affiliate");
    	System.out.println("Enter 3 for Key Customer");
    	int userTypeNo = scanner.nextInt();
    	UserType userType = getUserType(userTypeNo);
    	User user = new User(userType, cname);
    	return user;
	}

	private static UserType getUserType(int userTypeNo) {
		// TODO Auto-generated method stub
		switch(userTypeNo) {		
		case 1:
			return UserType.EMPLOYEE;
			
		case 2:
			return UserType.AFFILIATE;
			
		case 3:
			return UserType.KEYUSER;
			default:
				return UserType.SIMPLE;
		}
	}

	
}