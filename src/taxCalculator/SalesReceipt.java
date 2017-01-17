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
			while(!itemArray[i].equals("at")){
				itemDescription += itemArray[i]+ " ";
				i++;	
			}
			
			itemCart.setItemDescription(itemDescription.trim());
			calculateTax(itemCart);
			cart.addItemCart(itemCart);
		}
		
		return cart;
	}
	
	private void calculateTax(ItemCart itemCart){
		
		boolean b = Pattern.matches(".*(?i)book.*|.*(?i)chocolate.*|.*(?i)pill.*", itemCart.getItemDescription());
		BigDecimal tax = new BigDecimal(0);
		if(!b){
			tax = itemCart.getPrice().multiply(new BigDecimal(0.1).multiply(new BigDecimal (itemCart.getQuantity())));
		}
		
		b = Pattern.matches(".*(?i)imported.*", itemCart.getItemDescription());
		
		if(b){
			tax = tax.add(itemCart.getPrice().multiply(new 
					BigDecimal(0.05).multiply(new BigDecimal(itemCart.getQuantity()))));
		}
		
		BigDecimal scale = new BigDecimal(0.05);
		tax = ((tax.divide(scale)).setScale(0, BigDecimal.ROUND_UP)).multiply(scale);
		
		itemCart.setTax(tax);
		itemCart.setPrice(itemCart.getPrice().add(itemCart.getTax()).multiply(new BigDecimal (itemCart.getQuantity())));
	}
	
}

