package se.kth.iv1350.model;

import se.kth.iv1350.integration.PriceRounder;

/**
 * 
 * Represents the change given to the customer.
 *
 */

public class Change {
	double 	amount;
	
/**
 * Sets the amount of change given from the finished {@link Sale}.
 * 
 * @param sale The current {@link Sale}.
 */
	
	public Change(Sale sale) {
		amount = PriceRounder.round(sale.amountPaid.amount - sale.getTotalPrice(), 2);
	}
	
/**
 * Gets the amount of change.
 * 
 * @return Returns the amount.
 */
	
	public double getAmount() {
		return amount;
	}
}
