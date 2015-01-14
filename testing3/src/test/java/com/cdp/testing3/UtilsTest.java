package com.cdp.testing3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Joiner;



public class UtilsTest {	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Being deeply loved by someone gives you strength,"
				+ " while loving someone deeply gives you courage.");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Life is a series of natural and spontaneous changes."
				+ " Don't resist them - that only creates sorrow."
				+ " Let reality be reality. Let things flow naturally forward "
				+ "in whatever way they like.");
	}
	
	@Before
	public void beforeTest() {
		System.out.println("The journey of a thousand miles begins with one step.");
	}
	
	@After
	public void afterTest() {
		System.out.println("Mastering others is strength. Mastering yourself is true power.");
	}
	
	@Test
	public void concatenateWords_Ok() {
		String[] words = {"one", "two", "three", "four"};
		
		Assert.assertEquals(Joiner.on(" ").join(words), Utils.concatenateWords(words));
	}
	
	@Test
	public void computeFactorial_Ok() {
		Assert.assertEquals(1, Utils.computeFactorial(0));
		Assert.assertEquals(1*2*3*4, Utils.computeFactorial(4));
		Assert.assertEquals(1*2*3*4*5, Utils.computeFactorial(5));
	}
	
	@Test(timeout = 50) 
	public void testFactorialWithTimeout() {
		Assert.assertEquals(1*2*3*4, Utils.computeFactorial(4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExpectedException() {
		Utils.computeFactorial(-5);
	}
	
	@Ignore
	@Test
	public void testNormalizeWord() {
		Assert.assertEquals("fff", Utils.normalizeWord("FFf"));
	}
}
