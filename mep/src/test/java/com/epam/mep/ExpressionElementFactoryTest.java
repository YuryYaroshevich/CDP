package com.epam.mep;

import org.junit.Test;

import com.epam.mep.element.Division;
import com.epam.mep.element.ExpressionElement;
import com.epam.mep.element.ExpressionElementFactory;
import com.epam.mep.parser.ExpressionElementRegExp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

public class ExpressionElementFactoryTest {
    @Test
    public void createExpressionElement_Ok() {
        ExpressionElementFactory factory = new ExpressionElementFactory();
        ExpressionElement elem = factory.create(ExpressionElementRegExp.DIVISION, "/");
        
        assertThat(elem, instanceOf(Division.class));
    }
}
