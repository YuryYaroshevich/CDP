package com.cdp.testing4;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorPositiveTest {
	private Calculator calc = new Calculator();
	
	@Test
	public void add_Ok() {
		Assert.assertEquals(4, calc.add(3, 1));
	}
	
	@Test
	public void substract_Ok() {
		Assert.assertEquals(4, calc.subsctract(6, 2));
	}
	
	@Test
	public void multiply_Ok() {
		Assert.assertEquals(6, calc.multiply(2, 3));
	}
	
	@Test
	public void divide_Ok() {
		Assert.assertEquals(4.0, calc.divide(8, 2), 0.001);
	}
	
	@Test
	public void pow_Ok() {
		Assert.assertEquals(16, calc.pow(2, 4), 0.1);
	}
	
	@Test
	public void isPrime_Ok() {
		Assert.assertTrue(calc.isPrime(13));
	}
	
	@Test
	public void fibonacci_Ok() {
		MatcherAssert.assertThat(calc.fibonacci(4), Matchers.hasItems(0,1,2));
	}
}
