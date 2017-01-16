package test;

import java.util.ArrayList;

import taxCalculator.SalesReceipt;

public class Test {
	public static void main(String[] args){
		ArrayList<String> shoppingCart = new ArrayList<String>();
		shoppingCart.add("1 book at 12.49");
		shoppingCart.add("1 music CD at 14.99");
		shoppingCart.add("1 chocolate bar at 0.85");
		
		String taxed = new SalesReceipt(cart);
		
		
	}

}
