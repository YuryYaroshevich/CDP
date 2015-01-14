package com.epam.mep.element;

public class Multiplication extends AbstractExpressionElement {

    public Multiplication(String element) {
        super(element);
    }

    @Override
    public String toString() {
        return "Multiplication [element=" + element + "]";
    }
    
    
}
