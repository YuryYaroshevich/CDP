package com.epam.mep.parser;

import java.util.List;

public class ExpressionElementsRegExpBuilder {
    private List<ExpressionElementRegExp> regExpressions;
    
    public ExpressionElementsRegExpBuilder(
            List<ExpressionElementRegExp> regExpressions) {
        this.regExpressions = regExpressions;
    }

    public String buildRegExp() {
        StringBuilder fullRegExp = new StringBuilder();
        fullRegExp.append(regExpressions.get(0).getRegExp());
        for (int i = 1; i < regExpressions.size(); i++) {
            fullRegExp.append("|" + regExpressions.get(i).getRegExp());            
        }
        return fullRegExp.toString();
    }
}
