package com.epam.mep.element;

public abstract class AbstractExpressionElement implements ExpressionElement {
    protected String element;
    
    public AbstractExpressionElement(String element) {
        this.element = element;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((element == null) ? 0 : element.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractExpressionElement other = (AbstractExpressionElement) obj;
        if (element == null) {
            if (other.element != null)
                return false;
        } else if (!element.equals(other.element))
            return false;
        return true;
    }
}
