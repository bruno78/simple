package taxCalculator;

import java.util.ArrayList;

public class Cart {
	private ArrayList<ItemCart> itemCart;
	
	
	public ArrayList<ItemCart> getItemCart() {
		return itemCart;
	}

	public void addItemCart(ItemCart itemCart) {
		this.itemCart.add(itemCart);
	}

}
