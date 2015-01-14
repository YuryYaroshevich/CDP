package com.cdp.testing4;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorNegativeTest {
private Calculator calc = new Calculator();
	
	@Test(expected = IllegalArgumentException.class)
	public void divide_DivisionByZero_Exception() {
		calc.divide(8, 0);
	}
	
	@Test(timeout = 1)
	public void isPrime_BigNum() {
		Assert.assertFalse(calc.isPrime(99999999999999997l));
	}
}
