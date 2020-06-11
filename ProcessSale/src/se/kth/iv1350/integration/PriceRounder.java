package se.kth.iv1350.integration;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * A helper class allowing us to round prices to two decimal points.
 *
 */

public class PriceRounder {
	
/**
 * 
 * Rounds a double to a specified amount of decimal points.
 * 
 * @param value The double to round.
 * @param places The amount of decimal points.
 * @return Returns the double with the specified amount of decimal points.
 */

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}

