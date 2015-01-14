package com.cdp.testing7.operation.level;

import com.cdp.testing7.operation.DivideOperation;

public class FirstFormDivisionLevel extends AbstractLevel {

	public FirstFormDivisionLevel() {
		setMathOperation(new DivideOperation());
	}

	@Override
	public Operands getOperands() {
		int operand1 = operandGenerator.nextInt(100) + 1;
		int operand2;
		while ((operand1 % (operand2 = operandGenerator.nextInt(50) + 1))
				!= 0);
		return new Operands(operand1, operand2);
	}

}
