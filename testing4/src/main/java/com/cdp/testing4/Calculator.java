package com.cdp.testing4;

import java.util.ArrayList;
import java.util.List;


public class Calculator {
	public int add(int i1, int i2) {
		return i1 + i2;
	}
	
	public int subsctract(int minuend, int subtrahend) {
		return minuend - subtrahend;
	}
	
	public int multiply(int i1, int i2) {
		return i1 * i2;
	}
	
	public float divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		}
		return (float) (dividend / divisor);
	}
	
	public double root(float n) {
		return Math.sqrt(n);
	}
	
	public double pow(double base, double exp) {
		return Math.pow(base, exp);
	}
	
	public boolean isPrime(long n) {
		for (long i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public List<Integer> fibonacci(int len) {
		List<Integer> sequence = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			sequence.add(fibonacciElem(i));
		}
 		return sequence;
	}
	
	private int fibonacciElem(int index) {
		if (index == 0) {
			return 0;
		} else if (index == 1) {
			return 1;
		} else {
			return fibonacciElem(index - 1) + fibonacciElem(index - 2);
		}
	}
}
