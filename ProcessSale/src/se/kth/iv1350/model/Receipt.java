package se.kth.iv1350.model;
import java.time.format.*;

import se.kth.iv1350.integration.Printer;

/**
 * 
 * A class containing the receipt.
 *
 */

public class Receipt {
	
	Sale sale; 
	
/**
 * Creates a new instance, representing the sale and the time of sale.
 * 
 * @param sale The {@link Sale} represented by the newly created instance.
 */
	
	public Receipt(Sale sale) {
		this.sale = sale;
		System.out.println("Time of sale: " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(sale.saleTime));
	}
}
