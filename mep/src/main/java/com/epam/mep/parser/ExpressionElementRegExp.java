package com.epam.mep.parser;

public enum ExpressionElementRegExp  {
    MINUS("\\-"), PLUS("\\+"), OPEN_PARENTHESIS("\\("), CLOSING_PARENTHESIS("\\)"),
    MULTIPLICATION("\\*"), DIVISION("\\/"), NUMBER("\\d+");
    
    private String regExp;
    
    private ExpressionElementRegExp(String regExp) {
        this.regExp = regExp;
    }
    
    public String getRegExp() {
        return regExp;
    }    

}
