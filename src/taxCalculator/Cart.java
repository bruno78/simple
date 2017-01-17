package taxCalculator;

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

}
