package se.kth.iv1350.integration;

/**
 * 
 * Representing an item following the data transfer object (DTO)
 * pattern.
 *
 */

public class ItemDTO {
	
	String 	itemID;
	String 	name;
	double 	price;
	double 	vatRate;
	
	/**
	 * Creates an ItemDTO from the specified parameters.
	 * 
	 * @param itemID The item identifier of the product.
	 * @param name The name of the product.
	 * @param price The price of the product.
	 * @param vatRate The VAT rate of the product (6%, 12% or 25%)
	 */
	
	public ItemDTO(String itemID, String name, double price, double vatRate) {
		this.itemID = itemID;
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
	}
	
	/**
	 * Gets the item identifier of a product.
	 * 
	 * @return Returns the item identifier.
	 */
	
	public String getItemID() {
		return itemID;
	}
	
	/**
	 * Gets the name of a product.
	 * 
	 * @return Returns the name of the product.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the price of a product.
	 * 
	 * @return Returns the price of the product.
	 */
	
	public double getPrice() {
		return price;
	}
	
	/**
	 * Gets the VAT rate of a product.
	 * 
	 * @return Returns the VAT rate of the product.
	 */
	
	public double getVatRate() {
		return vatRate;
	}
}
