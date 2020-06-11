package se.kth.iv1350.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.model.Change;
import se.kth.iv1350.model.Sale;

class TestController {

	@Test
	void TestEnterItemIdentifier() throws Exception {
		Controller contr = new Controller();
		contr.startSale();
		boolean result = contr.enterItemIdentifier("001");
		assertTrue(result);
	}
	
	@Test
	void TestStartSale() {
		Controller contr = new Controller();
		contr.startSale();
	}
	
	@Test
	void TestMakePayment() {
		Controller contr = new Controller();
		contr.startSale();
		double amount = 10.0;
		Change change = contr.makePayment(amount);
		assertNotNull(change);
	}
	
	@Test
	void TestGetTotalPrice() {
		Controller contr = new Controller();
		contr.startSale();
		contr.getTotalPrice();
	}

}
