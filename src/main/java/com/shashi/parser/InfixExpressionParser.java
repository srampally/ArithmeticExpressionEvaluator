package com.shashi.parser;

import com.shashi.model.InfixExpression;

/**
 * Interface to be implemented by Infix Expression Parsers.
 * 
 * @author srampally
 */
public interface InfixExpressionParser
{
    InfixExpression parse(final String expression);
}
