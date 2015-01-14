package com.cdp.testing7;

import static org.easymock.EasyMock.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cdp.testing7.exercise.Exercise;
import com.cdp.testing7.exercise.ExerciseFactory;
import com.cdp.testing7.operation.MathOperation;
import com.cdp.testing7.operation.level.Level;
import com.cdp.testing7.operation.level.Operands;

@RunWith(EasyMockRunner.class)
public class ExerciseFactoryTest {
	@Mock(type = MockType.NICE)
	private List<Level> levels;
	@Mock
	public Level level;
	
	@TestSubject
	private ExerciseFactory exerciseFactory = new ExerciseFactory();
	
	@Test
	public void createExercise_Ok() {
		expect(levels.get(anyInt())).andReturn(level).once();
		expect(levels.size()).andReturn(4);
		Operands operands = new Operands(3, 4);
		expect(level.getOperands()).andReturn(operands).once();
		MathOperation operation = createMock(MathOperation.class);
		expect(level.getMathOperation()).andReturn(operation).once();
		
	    replay(levels);
	    replay(level);
	    
	    Exercise ex = exerciseFactory.createExercise();
	    verify(levels);
	    verify(level);
	    assertThat(ex, equalTo(new Exercise(
	    		operands.getFirstOperand(), operands.getSecondOperand(), operation)));
	}
}
