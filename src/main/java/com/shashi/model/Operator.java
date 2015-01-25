package com.shashi.model;

import java.util.Comparator;

/**
 * Arithmetic Operators.
 * 
 * @author srampally
 */
public enum Operator implements ArithmeticExpressionToken
{
    PLUS("+", 1)
    {
        public int getValue(final int left, final int right)
        {
            return left + right;
        }
    }, 
    MINUS("-", 1)
    {
        public int getValue(final int left, final int right)
        {
            return left - right;
        }
    },
    MULTIPLY("x", 2)
    {
        public int getValue(final int left, final int right)
        {
            return left * right;
        }
    },
    DIVIDE("/", 2)
    {
        public int getValue(final int left, final int right)
        {
            return left / right;
        }
    };
    
    public abstract int getValue(final int left, final int right);
    
    public static boolean isOperator(final String token)
    {
        for (final Operator operator : Operator.values())
        {
            if (operator.getName().equals(token))
            {
                return true;
            }
        }
        
        return false;
    }

    public static Operator withName(final String name)
    {
        for (final Operator operator : Operator.values())
        {
            if (operator.getName().equals(name))
            {
                return operator;
            }
        }
        
        return null;
    }

    public String getName()
    {
        return this.name;
    }
    
    public int getPrecedence()
    {
        return this.precedence;
    }

    private Operator(final String name, final int precedence)
    {
        this.name = name;
        this.precedence = precedence;
    }
    
    private final String name;
    private final int precedence;
    
    // nested classes
    
    public static class OperatorComparator implements Comparator<Operator>
    {
        @Override
        public int compare(final Operator left, final Operator right)
        {
            return left.getPrecedence() - right.getPrecedence();
        }
    }
}
