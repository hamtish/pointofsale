package se.kth.iv1350.model;

import se.kth.iv1350.integration.ItemDTO;

/**
 * 
 * A class containing item information.
 *
 */

public class Item {
	
	ItemDTO item;
	
/**
 * Set the {@link Item} provided by the {@link ItemDTO} class.
 * 
 * @param item The item.
 */
	
	public Item(ItemDTO item) {
		this.item = item;
	}
	
/**
 * Gets the {@link ItemDTO} contained in this class.
 * 
 * @return Returns the item.
 */
	
	public ItemDTO getItem() {
		return item;
	}
}
