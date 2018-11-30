package com.seongwon.calc;


import org.junit.Test;
import static org.junit.Assert.*;

import com.seongwon.calc.Calculator;


public class CalculatorTest{
    @Test
    public void testEvaluatePlus(){
        Calculator calc = new Calculator();
        assertEquals((int)calc.evaluate("+","1","2"), 3);
    }
}