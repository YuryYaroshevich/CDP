package com.cdp.testing7.exercise;

import com.cdp.testing7.operation.MathOperation;

public class Exercise {
	private double operand1;
	private double operand2;
	private MathOperation mathOperation;
	
	public Exercise(double operand1, double operand2,
			MathOperation mathOperation) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.mathOperation = mathOperation;
	}	
	
	public Exercise() {
	}
	
	public double getAnswer() {
		return mathOperation.count(operand1, operand2);
	}

	@Override
	public String toString() {
		return operand1 + " " + mathOperation.getSign() + " " + operand2 + " = " +  
				mathOperation.count(operand1, operand2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((mathOperation == null) ? 0 : mathOperation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(operand1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(operand2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercise other = (Exercise) obj;
		if (mathOperation == null) {
			if (other.mathOperation != null)
				return false;
		} else if (!mathOperation.equals(other.mathOperation))
			return false;
		if (Double.doubleToLongBits(operand1) != Double
				.doubleToLongBits(other.operand1))
			return false;
		if (Double.doubleToLongBits(operand2) != Double
				.doubleToLongBits(other.operand2))
			return false;
		return true;
	}
	
	
	
	
}
