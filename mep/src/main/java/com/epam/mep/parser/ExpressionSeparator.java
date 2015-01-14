package com.epam.mep.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSeparator {
    private ExpressionElementsRegExpBuilder regExpBuilder;
    
    public ExpressionSeparator(List<ExpressionElementRegExp> regExpressions) {
        regExpBuilder = new ExpressionElementsRegExpBuilder(regExpressions);
    }
    
    public List<String> parse(String expression) {
        String regExp = regExpBuilder.buildRegExp();
        Pattern p = Pattern.compile(regExp);
        Matcher matcher = p.matcher(expression);
        List<String> elements = new ArrayList<>();
        while (matcher.find()) {
            elements.add(matcher.group());
        }
        return elements;
    }
}
