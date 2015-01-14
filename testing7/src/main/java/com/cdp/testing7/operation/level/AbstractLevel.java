package com.cdp.testing7.operation.level;

import java.util.Random;

import com.cdp.testing7.operation.MathOperation;

public abstract class AbstractLevel implements Level {
	protected MathOperation mathOperation;
	protected Random operandGenerator = new Random();

	public void setMathOperation(MathOperation operation) {
		this.mathOperation = operation;
	}
	
	@Override
	public MathOperation getMathOperation() {
		return mathOperation;
	}
}
