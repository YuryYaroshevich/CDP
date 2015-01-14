package com.cdp.testing7.operation;


public class PlusOperation implements MathOperation {

	@Override
	public double count(double n1, double n2) {
		return n1 + n2;
	}

	@Override
	public String getSign() {
		return "+";
	}

}
