package se.kth.iv1350.integration;

/**
 * This exception is thrown if the item database fails. 
 */

public class DBFailureException extends RuntimeException {
	
	    int itemThatCrashedDatabase;
	    
	    /**
	     * Creates a new instance of <code>DBFailureException</code> without
	     * detail message.
 	     * @param itemID
	     */
	    
	    public DBFailureException(int itemID) {
	        super("DatabaseFailure. Caused by item: " + itemID);
	        itemThatCrashedDatabase = itemID;
	    }

	    /**
	     * Constructs an instance of <code>DBFailureException</code> with the
	     * specified message.
	     *
	     * @param msg the detail message.
	     */
	    
	    public DBFailureException(String msg) {
	    	super("Database failure was caused by item: " + msg);
	    }    
	}
