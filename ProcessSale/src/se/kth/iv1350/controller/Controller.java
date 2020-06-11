package se.kth.iv1350.controller;
import se.kth.iv1350.view.*;
import se.kth.iv1350.integration.ExternalSystemHandler;
import se.kth.iv1350.integration.ItemRegistry;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.RegistryHandler;
import se.kth.iv1350.integration.ItemWasNotFoundException;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.integration.DBFailureException;
import se.kth.iv1350.model.CashRegister;
import se.kth.iv1350.model.Change;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.Payment;
import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.Sale;
import se.kth.iv1350.model.SaleObserver;

/**
 * 
 * A class allowing the view to interact with the program.
 *
 */

public class Controller {
	
	CashRegister cashReg;
	ExternalSystemHandler exSysHandler;
	Printer printer;
	RegistryHandler regHandler;
	Sale sale;
	private List<SaleObserver> saleObservers = new ArrayList<>();
	
	/**
	 * Creates new instances for {@link ExternalSystemHandler}, {@link Printer},
	 * {@link RegistryHandler} and {@link CashRegister}.
	 */
	
	public Controller () {
		this.exSysHandler = new ExternalSystemHandler();
		this.printer = new Printer();
		this.regHandler = new RegistryHandler();
		this.cashReg = new CashRegister();
	}
	
	/**
	 * Creates a new instance of the Sale class to represent the current sale. 
	 */
	
	public void startSale() {
		this.sale = new Sale();
		sale.addListOfSaleObservers(saleObservers);
	}
	
	/**
	 * Sends the item identifier to the {@link ItemRegistry}, and checks
	 * if it is valid. If valid, the item is added to the list of
	 * items in the list of items in this current sale.
	 * 
	 * @param itemID The item identifier to send to the item registry.
	 * @return Returns true if the item identifier is valid.
	 */
	
	public boolean enterItemIdentifier(String itemID) throws ItemWasNotFoundException {
		
		regHandler.getItemReg().checkItem(itemID);
		Item item = regHandler.getItemReg().retriveItemInfo(itemID);
		sale.addQuantity(item);
			
		return true;
	}
	
	/**
	 * Ends the current sale.
	 */
	
	public void endSale() {
		
	}
	
	/**
	 * Gets the running total of all items registered in
	 * the current sale.
	 * 
	 * @return Returns the running total, including VAT
	 * of all items currently registered.
	 */
	
	public double getTotalPrice() {
		return sale.getTotalPrice();
	}
	
	/**
	 * Sends the payment to the system in the current sale,
	 * and also updates external systems.
	 * 
	 * @param amount The amount of <code>Change</code>.
	 * @return Returns the {@link Change} to give to the customer.
	 */
	
	public Change makePayment(double amount) {
		Change change = sale.finalizeSale(new Payment(amount));
		exSysHandler.updateExternalSystems(sale);
		cashReg.updateBalance(new Payment(amount - change.getAmount()));
		printer.printReceipt(new Receipt(sale));
		
		return change;
	}
	
	public void addSaleObserver (SaleObserver observer) {
		saleObservers.add(observer);
	}

}
