package com.epam.mep;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.mep.element.ClosingParenthesis;
import com.epam.mep.element.Division;
import com.epam.mep.element.ExpressionElement;
import com.epam.mep.element.Minus;
import com.epam.mep.element.Multiplication;
import com.epam.mep.element.Num;
import com.epam.mep.element.OpenParenthesis;
import com.epam.mep.element.Plus;
import com.epam.mep.parser.ExpressionTreeBuilder;
import com.google.common.collect.Lists;

public class ExpressionTreeBuilderTest {
    @Test
    public void build_Ok() {
        ExpressionTreeBuilder builder = new ExpressionTreeBuilder();
        List<ExpressionElement> expressionElements = builder.build(Lists.newArrayList("22","+","33","/","3","-","2","*","(","2","-","1",")"));
        
        
        Assert.assertTrue(expressionElements.get(0).equals(new Num("22")));
        Assert.assertTrue(expressionElements.get(1).equals(new Plus("+")));
        Assert.assertTrue(expressionElements.get(2).equals(new Num("33")));
        Assert.assertTrue(expressionElements.get(3).equals(new Division("/")));
        Assert.assertTrue(expressionElements.get(4).equals(new Num("3")));
        Assert.assertTrue(expressionElements.get(5).equals(new Minus("-")));
        Assert.assertTrue(expressionElements.get(6).equals(new Num("2")));
        Assert.assertTrue(expressionElements.get(7).equals(new Multiplication("*")));
        Assert.assertTrue(expressionElements.get(8).equals(new OpenParenthesis("(")));
        Assert.assertTrue(expressionElements.get(9).equals(new Num("2")));
        Assert.assertTrue(expressionElements.get(10).equals(new Minus("-")));
        Assert.assertTrue(expressionElements.get(11).equals(new Num("1")));
        Assert.assertTrue(expressionElements.get(12).equals(new ClosingParenthesis(")")));
    }
}
