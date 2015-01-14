package com.epam.mep;

import java.util.ArrayList;
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
import com.epam.mep.parser.MathExpressionParser;

public class MathExpressionParserTest {
    @Test
    public void parse_Ok() {
        MathExpressionParser parser = new MathExpressionParser();
        List<ExpressionElement> elements = parser.parse("22+33/3-2*(2-1)");
        
        Assert.assertTrue(elements.get(0).equals(new Num("22")));
        Assert.assertTrue(elements.get(1).equals(new Plus("+")));
        Assert.assertTrue(elements.get(2).equals(new Num("33")));
        Assert.assertTrue(elements.get(3).equals(new Division("/")));
        Assert.assertTrue(elements.get(4).equals(new Num("3")));
        Assert.assertTrue(elements.get(5).equals(new Minus("-")));
        Assert.assertTrue(elements.get(6).equals(new Num("2")));
        Assert.assertTrue(elements.get(7).equals(new Multiplication("*")));
        Assert.assertTrue(elements.get(8).equals(new OpenParenthesis("(")));
        Assert.assertTrue(elements.get(9).equals(new Num("2")));
        Assert.assertTrue(elements.get(10).equals(new Minus("-")));
        Assert.assertTrue(elements.get(11).equals(new Num("1")));
        Assert.assertTrue(elements.get(12).equals(new ClosingParenthesis(")")));
    }
}
