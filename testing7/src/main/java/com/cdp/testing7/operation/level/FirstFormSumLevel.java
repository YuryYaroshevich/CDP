package com.cdp.testing7.operation.level;

import com.cdp.testing7.operation.PlusOperation;

public class FirstFormSumLevel extends AbstractLevel {
	public FirstFormSumLevel() {
		setMathOperation(new PlusOperation());
	}

	@Override
	public Operands getOperands() {
		int operand1 = operandGenerator.nextInt(100);
		int operand2 = operandGenerator.nextInt(100);
		return new Operands(operand1, operand2);
	}

}
