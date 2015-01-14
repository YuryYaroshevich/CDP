package com.cdp.testing7.operation.level;

import com.cdp.testing7.operation.MutiplyOperation;

public class FirstFormMultiplicationLevel extends AbstractLevel {
	

	public FirstFormMultiplicationLevel() {
		setMathOperation(new MutiplyOperation());
	}

	@Override
	public Operands getOperands() {
		int operand1 = operandGenerator.nextInt(10) + 1;
		int operand2 = operandGenerator.nextInt(10) + 1;
		return new Operands(operand1, operand2);
	}

}
