package net.youmi.samples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Devin on 2016/9/20.
 */
public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void evaluate() throws Exception {
        int sum = calculator.evaluate("1+2+3");
        assertEquals(6, sum);
    }

}