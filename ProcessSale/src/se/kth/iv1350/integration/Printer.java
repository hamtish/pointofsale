package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;

/**
 * 
 * This class represents the printer.
 *
 */

public class Printer {
	public Printer() {
		
	}
	
/**
 * 
 * This would have printed the receipt.
 * 
 * @param receipt The receipt to print.
 */
	
	public void printReceipt (Receipt receipt) {
		System.out.println("Printing receipt... ");
		System.out.println("Receipt has been printed");
	}
}
