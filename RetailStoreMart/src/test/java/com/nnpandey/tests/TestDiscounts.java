package com.nnpandey.tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.nnpandey.retailstore.Item;
import com.nnpandey.retailstore.ItemType;
import com.nnpandey.retailstore.ShoppingCart;
import com.nnpandey.retailstore.User;
import com.nnpandey.retailstore.UserType;

/*
 * Test Cases for no discount policy
 */
public class TestDiscounts {

    private Item groceryItem;
    private Item otherItem;
    private User employee;
    private User affiliate;
    private User simpleUser;
    private User simpleUserWith2Years;

    @Before
    public void setUp() {
    	employee = new User(UserType.EMPLOYEE, "X");
    	affiliate = new User(UserType.AFFILIATE, "Y");
    	simpleUser = new User(UserType.KEYUSER, "Z");
        groceryItem = new Item("Sugar", 20, ItemType.GROCERY,5);
        otherItem = new Item("Box", 100, ItemType.OTHER,1);
        
    }

    @Test
    public void test_employeeWithGrocery() {
        ShoppingCart cart = new ShoppingCart(employee);
        cart.addToCart(groceryItem);
        assertEquals(95, cart.getTotal(), 0.01);
        
    }
    
    @Test
    public void test_employeeWithOtherItem() {
        ShoppingCart cart = new ShoppingCart(employee);
        cart.addToCart(otherItem);
        /*
         *  30% discount then 5 dollars off of each 100 dollars of total price because of other item
         *  Total 222 * 4 = 888
         *  After 30% discount = 621.6
         *  After 30 dollars off due to price over $600 = 591.6 
         */
        assertEquals(70, cart.getTotal(), 0.01);
        
    }
    
    @Test
    public void test_affiliateWithGrocery() {
        ShoppingCart cart = new ShoppingCart(affiliate);
        cart.addToCart(groceryItem);
        assertEquals(95, cart.getTotal(), 0.01);
        
    }
    
    @Test
    public void test_affiliateWithOtherItem() {
        ShoppingCart cart = new ShoppingCart(affiliate);
        cart.addToCart(otherItem);
        
        assertEquals(90, cart.getTotal(), 0.01);
        
    }
    
    @Test
    public void test_simpleUserWithGrocery() {
        ShoppingCart cart = new ShoppingCart(simpleUser);
        cart.addToCart(groceryItem);
        assertEquals(95, cart.getTotal(), 0.01);
        
    }
    
}
