package se.kth.iv1350.integration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.controller.Controller;

class TestItemWasNotFoundException {

	@Test
	void ItemWasNotFoundExceptionTest() throws Exception {
		Controller contr = new Controller();
		
		try {
			contr.enterItemIdentifier("007");
			fail("Could enter an invalid item identifier");
			
		} catch(ItemWasNotFoundException e) {
			assertTrue("Wrong exception message, does not " +
			"contain specified item identifier: " + e.getMessage(),
			e.getMessage().contains("007"));
		}
	}
}


