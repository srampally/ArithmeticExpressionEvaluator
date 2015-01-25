package com.shashi.model;

import java.util.List;

/**
 * Class that represents an Infix Arithmetic Expression.
 * 
 * @author srampally
 */
public class InfixExpression implements ArithmeticExpression
{
    @Override
    public int evaluate()
    {
        return new PostfixExpression(new TokenIterator(this.tokens)).evaluate();
    }

    public InfixExpression(final List<ArithmeticExpressionToken> tokens)
    {
        this.tokens = tokens;
    }
    
    private final List<ArithmeticExpressionToken> tokens;
}
