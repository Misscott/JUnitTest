package shopping;

import java.util.*;

public class ShoppingCart {
	private ArrayList<Product> items;

	public ShoppingCart() {
		items = new ArrayList<Product>();
	}

	public double getBalance() {
		double balance = 0.00;
		for (Iterator<Product> i = items.iterator(); i.hasNext();) {
			Product item = (Product) i.next();
			balance += item.getPrice();
		}
		return balance;
	}

	public void addItem(Product item) {
		items.add(item);
	}

	public void removeItem(Product item) {
		items.remove(item);
	}

	public int getItemCount() {
		return items.size();
	}

	public void empty() {
		items.clear();
	}
}
