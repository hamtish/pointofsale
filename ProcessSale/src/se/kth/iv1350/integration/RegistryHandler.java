package se.kth.iv1350.integration;

/**
 * 
 * A class containing the registers in the store.
 *
 */

public class RegistryHandler {
	
	ItemRegistry itemReg;
	
/**
 * 	Creates a new instance of the {@link ItemRegistry}.
 */
	
	public RegistryHandler() {
		this.itemReg = new ItemRegistry();
	}
	
/**
 * Gets the {@link ItemRegistry}.
 * 
 * @return Returns the {@link ItemRegistry}.
 */
	
	public ItemRegistry getItemReg() {
		return itemReg;
	}

}
