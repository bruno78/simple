package test;


import taxCalculator.Cart;
import taxCalculator.ItemCart;
import taxCalculator.SalesReceipt;

public class Test {
	public static void main(String[] args){
		
		String[] input1 = new String[3];
		input1[0] = ("1 book at 12.49");
		input1[1] = ("1 music CD at 14.99");
		input1[2] = ("1 chocolate bar at 0.85");
		
		String[] input2 = new String[2];
		input2[0] = ("1 imported box of chocolates at 10.00");
		input2[1] = ("1 imported bottle of perfume at 47.50");
		
		String[] input3 = new String[4];
		input3[0] = ("1 imported bottle of perfume at 27.99");
		input3[1] = ("1 bottle of perfume at 18.99");
		input3[2] = ("1 pack of headache pills at 9.75");
		input3[3] = ("1 box of imported chocolates at 11.25");
		
		SalesReceipt salesReceipt = new SalesReceipt();
		Cart cart = salesReceipt.createSalesReceipt(input1);
		
		for(ItemCart itemCart : cart.getItemCart()){
			System.out.println(itemCart.getQuantity() + " " + itemCart.getItemDescription() + ": " + itemCart.getPrice());
		}
		
		cart = salesReceipt.createSalesReceipt(input2);
		
		for(ItemCart itemCart : cart.getItemCart()){
			System.out.println(itemCart.getQuantity() + " " + itemCart.getItemDescription() + ": " + itemCart.getPrice());
		}
		
		cart = salesReceipt.createSalesReceipt(input3);
		
		for(ItemCart itemCart : cart.getItemCart()){
			System.out.println(itemCart.getQuantity() + " " + itemCart.getItemDescription() + ": " + itemCart.getPrice());
		}
		
	}

}
