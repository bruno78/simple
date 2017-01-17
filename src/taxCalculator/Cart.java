package taxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {
	private ArrayList<ItemCart> itemCart;
	
	
	public Cart(){
		itemCart = new ArrayList<ItemCart>();
	}
	
	public ArrayList<ItemCart> getItemCart(){
		return itemCart;
	}

	public void addItemCart(ItemCart itemCart) {
		this.itemCart.add(itemCart);
	}
	
	public void checkOut(){
		BigDecimal total = new BigDecimal(0);
		BigDecimal tax = new BigDecimal(0);
		
		for (ItemCart itemCart : this.getItemCart()){
			total = total.add(itemCart.getPrice());
			tax = tax.add(itemCart.getTax());
			System.out.println(itemCart.getQuantity() + " " + itemCart.getItemDescription() + ": " + 
			itemCart.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		System.out.println("Sales Taxes: " + tax.setScale(2, BigDecimal.ROUND_HALF_UP));
		System.out.println("Total: " + total.setScale(2, BigDecimal.ROUND_HALF_UP));
  }	


}
