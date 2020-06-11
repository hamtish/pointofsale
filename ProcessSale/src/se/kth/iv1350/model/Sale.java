package se.kth.iv1350.model;

import se.kth.iv1350.integration.LineItem;
import se.kth.iv1350.integration.PriceRounder;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * A class containing the sale. 
 *
 */

public class Sale {
	java.time.LocalDateTime saleTime;
	LineItem[] items;
	double totalPrice;
	double vatForSale;
	Payment amountPaid;
	Change change;
	private List<SaleObserver> saleObservers = new ArrayList<>();

/**
 * Creates a new instance, representing the sale.
 */
	
	public Sale() {
		this.saleTime = setTimeOfSale();
		items = new LineItem[0];
	}
	
	private java.time.LocalDateTime setTimeOfSale() {
		return java.time.LocalDateTime.now().withNano(0);
	}
	
/**
 * Adds an item to the list of items registered in the current sale.
 * 
 * @param item The {@link Item} to add to the list.
 */
	
	public void addQuantity(Item item) {
		for(LineItem lineItem : items) {
			if(lineItem.getItem().item.getItemID().equals(item.item.getItemID())) {
				lineItem.increaseQuantity();
				System.out.println("Item has already been entered, increasing quantity by 1");
				updateSale();
				return;
			}
		}
		
		LineItem[] newItem = new LineItem[items.length + 1];
		
		for (int i = 0; i < items.length; i++) {
			newItem[i] = items[i];
		}
		
		newItem[items.length] = new LineItem(item, 1);
		items = newItem;
		updateSale();
	}
	
	private void updateSale() {
		double totPrice = 0.00;
		double totVat = 0.00;
		
		for (int i = 0; i < items.length; i++) {
			for(int j = 0; j < items[i].getQuantity(); j++) {
				totPrice += PriceRounder.round(items[i].getItem().getItem().getPrice(), 2);
				totVat += PriceRounder.round(items[i].getItem().getItem().getPrice()*items[i].getItem().getItem().getVatRate(), 2);
			}
		}
		totalPrice = totPrice;
		vatForSale = totVat;

	}

/**
 * Gets the total price of the sale.
 * 
 * @return Returns the total price, including the vat for sale.
 */
	
	public double getTotalPrice() {
		return totalPrice + vatForSale;
	}
	
/**
 * Updates the sale class with the amount payed and the change being
 * returned to the customer.
 * 
 * @param amountPaid The amount payed by the customer.
 * @return Returns the change.
 */
	
	public Change finalizeSale(Payment amountPaid) {
		this.amountPaid = amountPaid;
		this.change = new Change(this);
		notifyingObserversOfPayment(amountPaid);
		
		return change;
	}
	
/**
 * Adds an observer to the current sale.
 * 
 * @param observer The observer which will be added to the sale.
 */
	
	public void addSaleObserver(SaleObserver observer) {
		saleObservers.add(observer);
	}
/**
 * Adds a list of observers to the current sale.
 * 
 * @param observers The list of observers.
 */
	
	public void addListOfSaleObservers (List<SaleObserver> observers) {
		for(SaleObserver observer : observers) {
			addSaleObserver(observer);
		}
	}

/**
 * Notifies observers of the current payment.
 * 
 * @param amountPaid The amount that has been paid. 
 */
	
	private void notifyingObserversOfPayment (Payment amountPaid) {
		for (SaleObserver observer : saleObservers) {
			observer.newPayment(amountPaid);
		}
	}

}
