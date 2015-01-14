package com.epam.mep.element;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.epam.mep.parser.ExpressionElementRegExp;

public class ExpressionElementFactory {
    Map<ExpressionElementRegExp, Class<?>> elementCreatorMapping = new HashMap<>();
    
    public ExpressionElementFactory() {
        elementCreatorMapping.put(ExpressionElementRegExp.CLOSING_PARENTHESIS, ClosingParenthesis.class);
        elementCreatorMapping.put(ExpressionElementRegExp.DIVISION, Division.class);
        elementCreatorMapping.put(ExpressionElementRegExp.MINUS, Minus.class);
        elementCreatorMapping.put(ExpressionElementRegExp.MULTIPLICATION, Multiplication.class);
        elementCreatorMapping.put(ExpressionElementRegExp.NUMBER, Num.class);
        elementCreatorMapping.put(ExpressionElementRegExp.OPEN_PARENTHESIS, OpenParenthesis.class);
        elementCreatorMapping.put(ExpressionElementRegExp.PLUS, Plus.class);
    }
    
    public ExpressionElement create(ExpressionElementRegExp exprRegExp, String expression) {
        try {
            Class<?> clazz = elementCreatorMapping.get(exprRegExp);
            Constructor<?> ctor = clazz.getConstructor(String.class);
            return (ExpressionElement) ctor.newInstance(expression);
        } catch (InstantiationException | IllegalAccessException | 
                NoSuchMethodException | SecurityException | 
                IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } 
    }
}
