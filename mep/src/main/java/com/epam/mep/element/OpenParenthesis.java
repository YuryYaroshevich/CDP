package com.epam.mep.element;

public class OpenParenthesis extends AbstractExpressionElement {

    public OpenParenthesis(String element) {
        super(element);
    }

    @Override
    public String toString() {
        return "OpenParenthesis [element=" + element + "]";
    }
    
}
