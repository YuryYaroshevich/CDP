package com.epam.mep.parser;

import java.util.ArrayList;
import java.util.List;

import com.epam.mep.element.ExpressionElement;
import com.epam.mep.element.ExpressionElementFactory;

public class ExpressionTreeBuilder {
    private ExpressionElementFactory elementfactory = new ExpressionElementFactory();
    
    public List<ExpressionElement> build(List<String> expressionElements) {
        List<ExpressionElement> tree = new ArrayList<>();
        for (String expression : expressionElements) {
            for (ExpressionElementRegExp regExp : ExpressionElementRegExp.values()) {
                if (expression.matches(regExp.getRegExp())) {
                    ExpressionElement elem = elementfactory.create(regExp, expression);
                    tree.add(elem);
                    break;
                }
            }
        }
        return tree;
    }
}
