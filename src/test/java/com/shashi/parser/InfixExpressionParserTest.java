package com.shashi.parser;

import junit.framework.Assert;

import org.junit.Test;

public class InfixExpressionParserTest
{
    @Test
    public void testParse()
    {
        final InfixExpressionParser infixExpressionParser = new InfixExpressionParserImpl();

        Assert.assertEquals(infixExpressionParser.parse("1 + 2").evaluate(), 3);
        Assert.assertEquals(infixExpressionParser.parse("1 + 2 - 1").evaluate(), 2);
        Assert.assertEquals(infixExpressionParser.parse("1 + 2 x 3").evaluate(), 7);
        Assert.assertEquals(infixExpressionParser.parse("1 + 2 x 4 / 2").evaluate(), 5);
        Assert.assertEquals(infixExpressionParser.parse("1 + 2 x 3 + 4 - 5").evaluate(), 6);
    }
}
