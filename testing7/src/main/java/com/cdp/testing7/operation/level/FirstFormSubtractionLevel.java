package com.cdp.testing7.operation.level;

import com.cdp.testing7.operation.MinusOperation;

public class FirstFormSubtractionLevel extends AbstractLevel {	
	
	public FirstFormSubtractionLevel() {
		setMathOperation(new MinusOperation());
	}

	@Override
	public Operands getOperands() {
		int operand1 = operandGenerator.nextInt(100);
		int operand2 = operandGenerator.nextInt(operand1);		
		return new Operands(operand1, operand2);
	}
}
