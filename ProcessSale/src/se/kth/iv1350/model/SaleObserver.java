package se.kth.iv1350.model;

/**
 * The interface SaleObserver observes the current sale. 
 *
 */


public interface SaleObserver {
	
	/**
	 * Invoked when a sale has been made, notifying all observers with the current amount. 
	 * 
	 * @param amount The amount of the {@link Payment}.
	 * 
	 */
	
	void newPayment(Payment amount);	

}
