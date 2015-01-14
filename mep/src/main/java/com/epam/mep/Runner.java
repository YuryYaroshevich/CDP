package com.epam.mep;

import com.epam.mep.parser.MathExpressionParser;



public class Runner {
    public static void main(String[] args) {
        System.out.println(new MathExpressionParser().parse("2+3*(2-5*9 - 8/4)"));
    }
}
