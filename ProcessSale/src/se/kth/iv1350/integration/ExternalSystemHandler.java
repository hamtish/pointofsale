package se.kth.iv1350.integration;

import se.kth.iv1350.model.Sale;

/**
 * 
 * A class containing the external systems present in the store.
 *
 */

public class ExternalSystemHandler {
	
	InventorySystem invSys;
	AccountingSystem accSys;
	SaleLog saleLog;
	
	/**
	 * Creates new instances of {@link InventorySystem}, {@link AccountingSystem},
	 * and {@link SaleLog}.
	 */
	
	public ExternalSystemHandler() {
		this.invSys = new InventorySystem();
		this.accSys = new AccountingSystem();
		this.saleLog = new SaleLog();
	}
	
	/**
	 * This would have updated all external systems.
	 * 
	 * @param sale The current {@link Sale}.
	 */
	
	public void updateExternalSystems(Sale sale) {
		System.out.println("Accounting and inventory system has been updated");
		saleLog.logSale(sale);
	}
	
	/**
	 * Gets the information from the inventory system.
	 * 
	 * @return Returns the information from the {@link InventorySystem}.
	 */
	
	public InventorySystem getInvSys() {
		return invSys;
	}
	
	/**
	 * Gets the information from the accounting system.
	 * 
	 * @return Returns the information from the {@link AccountingSystem}.
	 */
	
	public AccountingSystem getAccSys() {
		return accSys;
	}
	
	/**
	 * Gets the information from the sale log.
	 * 
	 * @return Returns the information from the {@link SaleLog}.
	 */
	
	public SaleLog getSaleLog() {
		return saleLog;
	}

}
