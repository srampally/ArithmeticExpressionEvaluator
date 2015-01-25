package com.shashi.parser;

import java.util.ArrayList;
import java.util.List;

import com.shashi.model.InfixExpression;
import com.shashi.model.ArithmeticExpressionToken;
import com.shashi.model.Operand;
import com.shashi.model.Operator;

/**
 * Default Infix Expression Parser implementation.
 * 
 * @author srampally
 */
public class InfixExpressionParserImpl implements InfixExpressionParser
{
    @Override
    public InfixExpression parse(final String expression)
    {
        if (expression == null || expression.isEmpty())
        {
            throw new IllegalArgumentException("Expression cannot be null/empty!");
        }
        
        final String[] tokens = expression.split(" ");

        if (tokens.length < 3 || tokens.length % 2 == 0)
        {
            throw new IllegalArgumentException("Invalid Infix Expression!");
        }

        final List<ArithmeticExpressionToken> expressionTokens = new ArrayList<ArithmeticExpressionToken>(); 
        
        for (int i = 0; i < tokens.length; i++)
        {
            final String token = tokens[i];
            
            if (i % 2 == 1)
            {
                if (!Operator.isOperator(token))
                    throw new IllegalArgumentException("Was expecting an operator, but found: " + token);
                
                expressionTokens.add(Operator.withName(token));
            } else
            {
                try 
                {
                    final int operandValue = Integer.valueOf(token);
                    expressionTokens.add(new Operand(operandValue));
                } catch (final NumberFormatException nfe)
                {
                    throw new IllegalArgumentException("Was expecting an operand, but found: " + token, nfe);
                }
            }
        }
        
        return new InfixExpression(expressionTokens);
    }
}
