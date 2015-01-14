package com.cdp.testing7;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.easymock.EasyMock.*; 

import com.cdp.testing7.exercise.Exercise;
import com.cdp.testing7.operation.MathOperation;


public class ExerciseTest {
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	
	@Mock
	private MathOperation mathOperation;
	
	@TestSubject
	private Exercise exercise = new Exercise();
	
	@Test
	public void getAnswer_MathOperationCalled() {
		expect(mathOperation.count(anyDouble(), anyDouble())).andReturn(0.0).times(1);
		replay(mathOperation);
		double answer = exercise.getAnswer();
		
		verify(mathOperation);
		assertThat(answer, equalTo(0.0));
	}
}
