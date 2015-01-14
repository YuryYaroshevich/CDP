package com.cdp.testing7.operation.level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FirstFormDivisionLevelTest {
	
	private Level level = new FirstFormDivisionLevel();
	
	@Test
	public void getOperands_FirstDividedIntoSecond() {
		Operands operands = level.getOperands();
		double remainder = operands.getFirstOperand() % operands.getSecondOperand();
		assertThat(remainder, equalTo(0.0));
	}
}
