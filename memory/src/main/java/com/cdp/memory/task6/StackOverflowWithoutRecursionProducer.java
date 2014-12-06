package com.cdp.memory.task6;

public class StackOverflowWithoutRecursionProducer {

	public static void main(String[] args) {
		try {
			foo();
		} catch (StackOverflowError e) {
			System.out.println(e);
		}
	}
	
	private static void foo() {
		bar();
	}
	
	private static void bar() {
		foo();
	}
}
