package se.kth.iv1350.model;
import java.util.List;
import java.util.ArrayList;
import se.kth.iv1350.view.*;


/**
 * Represents the cash register of the store.
 */

public class CashRegister {
	
	double amount;
	private List <TotalRevenueView> observersOfRevenue = new ArrayList<>();
	
	public CashRegister() {
		
	}
	
/**
* This method is used to add an observer to the current list with observers. 
* @param view is used to display something from the program.
*/
	
	public CashRegister(TotalRevenueView view) {
		this.observersOfRevenue.add(view);
	}
	
/**
 * Updates the balance in the {@link CashRegister}.
 * 
 * @param amountPaid The amount paid by a costumer.
 */
	
	public void updateBalance(Payment amountPaid) {
		amount += amountPaid.amount;
		System.out.println("Cash register has been updated");
	}
	
/**
 * This method adds an observer to the current list with observers of the revenue.
 */
	
	public void setObserver (TotalRevenueView currentViewer) {
		this.observersOfRevenue.add(currentViewer);
	}

	
}
