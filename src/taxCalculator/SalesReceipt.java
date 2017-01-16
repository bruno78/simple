package taxCalculator;

import java.math.BigDecimal;

public class SalesReceipt {
	
	Cart cart;
	
	public SalesReceipt(String[] cartArray){
		cart = CreateCart(cartArray);		
	}
	
	private Cart CreateCart(String[] cartArray) {
		Cart cart = new Cart();
		ItemCart itemCart;
		
		for(String item : cartArray) {
			String[] itemArray = item.split(" ");
			itemCart = new ItemCart();		
			itemCart.setQuantity(new Integer (itemArray[0]));
			itemCart.setPrice(new BigDecimal (itemArray[itemArray.length-1]));
			
			Integer i = 1;
			String itemDescription = new String();
			while(itemArray[i].equals("at")){
				itemDescription = itemArray[i]+ " ";
				i++;	
			}
			
			itemCart.setItemDescription(itemDescription.trim());
			
			cart.addItemCart(itemCart);
		}
		
		return cart;
	}
	
	private void calculateTax(ItemCart itemCart){
		if(itemCart.getItemDescription().contains(s))
	}

}

