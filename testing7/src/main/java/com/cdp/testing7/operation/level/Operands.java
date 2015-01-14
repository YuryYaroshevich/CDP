package com.cdp.testing7.operation.level;

public class Operands {
	private double operand1;
	private double operand2;
	
	public Operands(double operand1, double operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public double getFirstOperand() {
		return operand1;
	}

	public double getSecondOperand() {
		return operand2;
	}
}
