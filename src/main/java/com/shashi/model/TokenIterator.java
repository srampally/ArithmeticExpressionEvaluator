package com.shashi.model;

import java.util.Iterator;
import java.util.List;

/**
 * Iterator for Tokens.
 *  
 * @author srampally
 */
public class TokenIterator implements Iterator<ArithmeticExpressionToken>
{
    private final Iterator<ArithmeticExpressionToken> iterator;
    
    public TokenIterator(final List<ArithmeticExpressionToken> tokens)
    {
        this.iterator = tokens.iterator();
    }

    @Override
    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    @Override
    public ArithmeticExpressionToken next()
    {
        return iterator.next();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Removing tokens is not allowed!");
    }
}
