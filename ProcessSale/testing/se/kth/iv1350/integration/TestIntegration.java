package se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.Sale;

class TestIntegration {

	@Test
	void TestUpdateExternalSystems() {
		ExternalSystemHandler exSys = new ExternalSystemHandler();
		Sale sale = new Sale();
		exSys.updateExternalSystems(sale);
	}
	
	@Test
	void TestCheckItem() throws ItemWasNotFoundException {
		ItemRegistry itemreg = new ItemRegistry();
		itemreg.checkItem("001");
	}
	
	@Test
	void TestRetriveItemInfo() {
		ItemRegistry item = new ItemRegistry();
		item.retriveItemInfo("555");
	}
	
	@Test
	void TestPrintReceipt() { 
		Sale sale = new Sale();
		Receipt receipt = new Receipt(sale);
		Printer printer = new Printer();
		printer.printReceipt(receipt);
	}
	
	@Test
	void TestLogSale() {
		Sale sale = new Sale();
		SaleLog salelog = new SaleLog();
		salelog.logSale(sale);
	}
	
	@Test
	void TestPriceRounder() {
		double value = 5.555;
		int places = 2;
		PriceRounder.round(value, places);
	}

}
