package com.epam.mep.parser;

import java.util.List;

import com.epam.mep.element.ExpressionElement;
import com.google.common.collect.Lists;

public class MathExpressionParser {
    private ExpressionSeparator separator = new ExpressionSeparator(Lists.newArrayList(ExpressionElementRegExp.values()));
    private ExpressionTreeBuilder treeBuilder = new ExpressionTreeBuilder();
    
    public List<ExpressionElement> parse(String expr) {
        List<String> parts = separator.parse(expr);
        return treeBuilder.build(parts);
    }
}
