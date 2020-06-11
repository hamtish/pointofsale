package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.DBFailureException;
import se.kth.iv1350.integration.ItemWasNotFoundException;
import se.kth.iv1350.view.View;


public class Main {
	
/**
 * This is the main method.
 * @throws ItemWasNotFoundException 
 * @throws DBFailureException 
 */
	
	public static void main(String[] args) throws Exception {
		Controller 	contr = new Controller();
		View 		vy = new View(contr);
		vy.openStore();
	}

}
