package taxCalculator;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SalesReceipt {
	
	Cart cart;
	
	public Cart createSalesReceipt(String[] cartArray){
		cart = convertCart(cartArray);
		return cart;
	}
	
	private Cart convertCart(String[] cartArray) {
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
			calculateTax(itemCart);
			cart.addItemCart(itemCart);
		}
		
		return cart;
	}
	
	private void calculateTax(ItemCart itemCart){
		
		boolean b = Pattern.matches("(?i)book.*|(?i)chocolate.*|(?i)pill.*", itemCart.getItemDescription());
		
		if(!b){
			itemCart.setTax(itemCart.getPrice().multiply(new BigDecimal(1.1)));
			
		}
		
		b = Pattern.matches("(?i)imported.*", itemCart.getItemDescription());
		
		if(b){
			itemCart.setTax(itemCart.getPrice().multiply(new BigDecimal(1.05)));
		}
	  }
		

}

