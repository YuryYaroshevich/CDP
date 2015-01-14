package com.epam.mep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.List;

import org.junit.Test;

import com.epam.mep.parser.ExpressionElementRegExp;
import com.epam.mep.parser.ExpressionSeparator;
import com.google.common.collect.Lists;

public class ExpressionSeparatorTest {

    @Test
    public void parse_Ok() {
        ExpressionSeparator expressionSeparator = new ExpressionSeparator(Lists.newArrayList(ExpressionElementRegExp.values()));
        List<String> expressionElements = expressionSeparator.parse("2+3*(2-5*9 - 8/4)");
        
        assertThat(expressionElements, contains("2","+","3","*","(","2","-","5","*","9","-","8","/","4",")"));
    }
}
