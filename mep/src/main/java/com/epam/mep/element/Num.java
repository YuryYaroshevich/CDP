package com.epam.mep.element;

public class Num extends AbstractExpressionElement {

    public Num(String element) {
        super(element);
    }

    @Override
    public String toString() {
        return "Num [element=" + element + "]";
    }
    
    
}
