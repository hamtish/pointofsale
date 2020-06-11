package se.kth.iv1350.integration;

import se.kth.iv1350.model.Item;

/**
 * 
 * Represents an item registered in the sale, with a corresponding
 * quantity of the item(s).
 *
 */

public class LineItem {
	
	Item item;
	int quantity;

/**
 * 
 * @param item The item to register.
 * @param quantity The quantity of the item(s).
 */
	
	public LineItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
/**
 * Gets the {@link Item} from the {@link LineItem}.
 * 
 * @return Returns the {@link Item}.
 */
	
	public Item getItem() {
		return item;
	}
	
/**
 * Gets the quantity of items in the {@link LineItem}.
 * 
 * @return Returns the quantity of items registered.
 */
	
	public int getQuantity() {
		return quantity;
	}
	
/**
 * Increases the quantity of {@link Item} in the {@link LineItem} by 1.
 */
	
	public void increaseQuantity() {
		quantity++;
	}

/**
 * Decreases the quantity of {@link Item} in the {@link LineItem} by 1.
 */
	
	public void decreaseQuantity() {
		if (quantity <= 0)
			return;
		quantity--;
			
	}

}
