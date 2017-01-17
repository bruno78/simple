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
		
		SalesReceipt salesReceipt = new SalesReceipt();
		Cart cart = salesReceipt.createSalesReceipt(input1);
		
		for(ItemCart itemCart : cart.getItemCart()){
			System.out.println(itemCart.getQuantity() + " " + itemCart.getItemDescription() + ": " + itemCart.getPrice());
		}
		
	}

}
