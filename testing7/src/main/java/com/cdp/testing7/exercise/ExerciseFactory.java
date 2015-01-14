package com.cdp.testing7.exercise;

import java.util.List;
import java.util.Random;

import com.cdp.testing7.operation.MathOperation;
import com.cdp.testing7.operation.level.Level;
import com.cdp.testing7.operation.level.Operands;

public class ExerciseFactory {
	private List<Level> levels;
	private Random levelGenerator = new Random();

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public Exercise createExercise() {
		Level level = levels.get(levelGenerator.nextInt(levels.size()));
		Operands operands = level.getOperands();
		MathOperation mathOperation = level.getMathOperation();
		return new Exercise(operands.getFirstOperand(),
				operands.getSecondOperand(), mathOperation);
	}
}
