package com.shashi.model;

/**
 * Operand of course.
 * 
 * @author srampally
 */
public class Operand implements ArithmeticExpressionToken
{
    public int getValue() {
        return value;
    }
    public Operand(final int value) {
        this.value = value;
    }
    
    private final int value;
}
