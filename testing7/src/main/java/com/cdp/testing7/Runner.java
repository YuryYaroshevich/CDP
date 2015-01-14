package com.cdp.testing7;

import java.util.ArrayList;
import java.util.List;

import com.cdp.testing7.exercise.Exercise;
import com.cdp.testing7.exercise.ExerciseFactory;
import com.cdp.testing7.operation.level.FirstFormDivisionLevel;
import com.cdp.testing7.operation.level.FirstFormMultiplicationLevel;
import com.cdp.testing7.operation.level.FirstFormSubtractionLevel;
import com.cdp.testing7.operation.level.FirstFormSumLevel;
import com.cdp.testing7.operation.level.Level;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		ExerciseFactory exerciseFactory = new ExerciseFactory();
		List<Level> levels = new ArrayList<>();
		levels.add(new FirstFormDivisionLevel());
		levels.add(new FirstFormMultiplicationLevel());
		levels.add(new FirstFormSubtractionLevel());
		levels.add(new FirstFormSumLevel());
		
		exerciseFactory.setLevels(levels);
		
		while (true) {
			Exercise ex = exerciseFactory.createExercise();
			System.out.println(ex);
			Thread.sleep(1500);
		}
	}

}
