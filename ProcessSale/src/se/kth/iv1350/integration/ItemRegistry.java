package se.kth.iv1350.integration;

import se.kth.iv1350.model.Item;

/**
 * 
 * Represents an item database in the store.
 *
 */

public class ItemRegistry {
	
	Item[] items;
	
/**
 * Creates new items in the item registry database.
 */
	
	public ItemRegistry() {
		items = new Item[5];
		
		ItemDTO itemDTO = new ItemDTO("001", "Milk", 12.0, 0.12);
		items[0] = new Item(itemDTO);
		itemDTO = new ItemDTO("002", "Sugar", 20.0, 0.12);
		items[1] = new Item(itemDTO);
		itemDTO = new ItemDTO("003", "Honey", 30.0, 0.12);
		items[2] = new Item(itemDTO);
		itemDTO = new ItemDTO("004", "Newspaper", 10.0, 0.06);
		items[3] = new Item(itemDTO);
		itemDTO = new ItemDTO("005", "Ciggarettes", 50.0, 0.25);
		items[4] = new Item(itemDTO);
		
	}
	
/**
 * Checks if the item identifier exist in the item registry.
 * 
 * @param itemID The item identifier of the product.
 * @return Returns true if the item exists in the item registry, else false.
 */
	
	public boolean checkItem(String itemID) throws ItemWasNotFoundException, DBFailureException {
		
		if(itemID.equals("500"))
			throw new DBFailureException(itemID);
		
		for (Item item : items) {
			if (item.getItem().getItemID().equals(itemID))
				return true;
		}
		
		throw new ItemWasNotFoundException(itemID);
			
	}
	
/**
 * Retrieves the item from the item registry.
 * 
 * @param itemID The item identifier of the product.
 * @return Returns the item if the item identifier exist in the item
 * registry, else null.
 */
	
	public Item retriveItemInfo(String itemID) {
		for (Item item : items) {
			if (item.getItem().getItemID().equals(itemID))
				return item;
		}
		return null;
	}

}
