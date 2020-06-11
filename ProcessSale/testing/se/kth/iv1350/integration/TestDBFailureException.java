package se.kth.iv1350.integration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.controller.Controller;

class TestDBFailureException {

	@Test
	void DBFailureTest() throws Exception {
		Controller contr = new Controller();
		
		try {
			contr.enterItemIdentifier("500");
			fail("Could enter an invalid item identifier");
			
		} catch(DBFailureException e) {
			assertTrue("Wrong exception message, does not " +
			"contain specified item identifier: " + e.getMessage(),
			e.getMessage().contains("500"));
		}
	}

}
