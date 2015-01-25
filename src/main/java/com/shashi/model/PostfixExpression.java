package com.shashi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.shashi.model.Operator.OperatorComparator;

/**
 * A class that represents a Postfix Arithmetic Expression.
 * 
 * @author srampally
 */
public class PostfixExpression implements ArithmeticExpression
{
    @Override
    public int evaluate()
    {
        final Stack<Operand> operandStack = new Stack<>();
        for (final ArithmeticExpressionToken token : this.tokens)
        {
            if (token instanceof Operator)
            {
                final Operator operator = (Operator) token;
                final Operand rightOperand = operandStack.pop();
                final Operand leftOperand = operandStack.pop();
                
                operandStack.push
                (
                    new Operand
                    (
                        operator.getValue
                        (
                            leftOperand.getValue(),
                            rightOperand.getValue()
                        )
                    )
                );
            } else {
                operandStack.push((Operand)token);
            }
        }
        
        return operandStack.pop().getValue();
    }

    public PostfixExpression(final TokenIterator infixExpressionTokenIterator)
    {
        final Stack<Operator> operatorStack = new Stack<>();
        this.tokens = new ArrayList<>();
        
        while (infixExpressionTokenIterator.hasNext())
        {
            final ArithmeticExpressionToken token = infixExpressionTokenIterator.next();
            
            if (token instanceof Operator)
            {
                final Operator operator = (Operator) token;
                
                while (!operatorStack.isEmpty() && OPERATION_COMPARATOR.compare(operatorStack.peek(), operator) > 0)
                {
                    this.tokens.add(operatorStack.pop());
                }
                operatorStack.push(operator);
            } else 
            {
                this.tokens.add(token);
            }
        }
        
        while (!operatorStack.isEmpty())
        {
            this.tokens.add(operatorStack.pop());
        }
    }

    private final static OperatorComparator OPERATION_COMPARATOR = new OperatorComparator();
    private final List<ArithmeticExpressionToken> tokens;
}
