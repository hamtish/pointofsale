package se.kth.iv1350.view;

import se.kth.iv1350.model.Payment;
import se.kth.iv1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
	
	public double totalRevenue;

	    public TotalRevenueView() {
	   	 
	        totalRevenue = 0.0;
	    }

	    public void newPayment(Payment amountPaid) {
	    	
	        totalRevenue += amountPaid.amount;
	        
	        System.out.println("Total revenue is: " + totalRevenue + " SEK");
	    }
	}

