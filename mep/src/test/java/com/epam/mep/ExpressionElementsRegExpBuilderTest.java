package com.epam.mep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import com.epam.mep.parser.ExpressionElementRegExp;
import com.epam.mep.parser.ExpressionElementsRegExpBuilder;
import com.google.common.collect.Lists;

public class ExpressionElementsRegExpBuilderTest {
    @Test
    public void buildRegExp_Ok() {
        ExpressionElementsRegExpBuilder builder = new ExpressionElementsRegExpBuilder(Lists.newArrayList(
                ExpressionElementRegExp.CLOSING_PARENTHESIS, ExpressionElementRegExp.DIVISION, ExpressionElementRegExp.NUMBER));

        String regExp = builder.buildRegExp();
        
        assertThat(regExp, equalTo(ExpressionElementRegExp.CLOSING_PARENTHESIS.getRegExp() +
                "|" + ExpressionElementRegExp.DIVISION.getRegExp() + "|" + ExpressionElementRegExp.NUMBER.getRegExp()));
    }
}
