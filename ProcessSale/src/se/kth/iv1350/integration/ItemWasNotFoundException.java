package se.kth.iv1350.integration;

/**
 * This exception is thrown when the searched item does not exist in the database.
 */

public class ItemWasNotFoundException extends Exception {
	
	    int itemID;
	    
	    /**
	     * Creates a new instance of <code>ItemWasNotFoundException</code> without
	     * detail message.
	     * @param itemID
	     */
	    
	    public ItemWasNotFoundException(int itemID) {
	        super("The item does not exist in the registry. The item identifier is: " + itemID);
	        this.itemID = itemID; 
	    }
	    
	    /**
	     * Gets the itemID that could not be found.
	     * @return itemID
	     */
	    
	    public int getItemID() {
	        return itemID;
	    }

	    /**
	     * Constructs an instance of <code>ItemWasNotFoundException</code> with the
	     * specified detail message.
	     *
	     * @param msg the detail message.
	     */
	    
	    public ItemWasNotFoundException(String msg) {
	    	 super("The item does not exist in the registry. \nThe item identifier is: " + msg);
	    }
}
