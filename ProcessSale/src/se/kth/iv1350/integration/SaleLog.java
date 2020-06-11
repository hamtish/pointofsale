package se.kth.iv1350.integration;

import se.kth.iv1350.model.Sale;

/**
 * 
 * Represents the sale log of the store.
 *
 */

public class SaleLog {
	
	Sale[] saleLog;
	
/**
 * Creates a sale log.
 */
	
	public SaleLog() {
		saleLog = new Sale[0];
	}

/**
 * Logs the finished {@link Sale} and saves it in the {@link Sale} log.
 * 
 * @param sale The current sale to log.
 */
	
	public void logSale (Sale sale) {
		Sale[] newSaleLog = new Sale[saleLog.length + 1];
		
		for(int i = 0; i < saleLog.length; i++) {
			newSaleLog[i] = saleLog[i]; 
		}
		newSaleLog[saleLog.length] = sale;
		saleLog = newSaleLog;
		System.out.println("This sale has been logged");
	}

}
