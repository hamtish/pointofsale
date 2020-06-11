package se.kth.iv1350.view;
import se.kth.iv1350.view.TotalRevenueView;
import java.util.Scanner;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.DBFailureException;
import se.kth.iv1350.integration.ItemWasNotFoundException;
import se.kth.iv1350.integration.RegistryHandler;
import se.kth.iv1350.model.Change;
import se.kth.iv1350.model.Payment;
import se.kth.iv1350.model.Item;

import java.util.Random;
import se.kth.iv1350.model.Sale;
/**
 * 
 * A class representing the view for the cashier to interact with the program.
 *
 */

public class View {
	
	Controller contr;
	View view;
	Payment amount;

/**
 * Creates an instance of the {@link View}.
 * 
 * @param contr The {@link Controller} needed for the {@link View} to interact
 * with the system.
 */
			
	public View(Controller contr) {
		this.contr = contr;
		contr.addSaleObserver(new TotalRevenueView());
		System.out.println("The store is open");
	}
	
/**
 * Receives inputs and gives outputs to the user interacting with the {@link View}.
 * @throws ItemWasNotFoundException 
 * @throws DBFailureException 
 */
	
	public void openStore() throws Exception {
		Random rand = new Random();
		int items = rand.nextInt(8) + 3;
		System.out.println("A new customer has appeared with " + items + " items to buy");
		contr.startSale();
		
		Scanner		in = new Scanner (System.in);
		
		String s = "";
		
		while(items > 0) {
			RegistryHandler regHandler = new RegistryHandler();
			System.out.println("Enter item identifier (from 001-005): ");
			s = in.next();
			Item item = regHandler.getItemReg().retriveItemInfo(s);
			try {
				if(contr.enterItemIdentifier(s)) {
					System.out.println(item.getItem().getName() + "    " + item.getItem().getPrice());
					System.out.println("Total price is: " + contr.getTotalPrice());
					items--;
				}
			}
			
			catch(Exception e) {
				System.out.println(e);
			}
				
		}
		
		boolean buyMore = false;
		
		while(!buyMore) {
			System.out.println("Do the customer wish to buy more?");
			s = in.next();
			if(s.equals("no"))
				break;
			else if(s.equals("yes")) {
				System.out.println("NOT IMPLEMENTED"); 
			}
			else
				System.out.println("Invalid command, answer is either yes or no");
		}
		contr.endSale();
		
		System.out.println("Cashier has ended sale");
		System.out.println("Total price including VAT is: " + contr.getTotalPrice());

		boolean validAmount = false;
		
		while(!validAmount) {
			System.out.println("Enter amount paid by customer: ");
			double amount = in.nextDouble();
			
			if(amount < contr.getTotalPrice()) {
				System.out.println("Amount paid is too low, try again");
			}
			else {
				System.out.println("Customer paid: " + amount);
				Change change = contr.makePayment(amount);
				System.out.println("Cashier returned change: " + change.getAmount());
				validAmount = true;
			}
				
		}
	
		System.out.println("Customer leaves with receipt and goods!");
		System.out.println("\n \n \n \n");
		openStore();
	}	

}
