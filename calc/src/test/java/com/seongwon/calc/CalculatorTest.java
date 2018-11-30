package com.seongwon.calc;


import org.junit.Test;
import static org.junit.Assert.*;

import com.seongwon.calc.Calculator;


public class CalculatorTest{
    Calculator calc = new Calculator();

    @Test
    public void testEvaluatePlus(){
        assertEquals((int)calc.evaluate("+","1","2"), 3);
    }
    @Test
    public void testGetANumber(){
        calc.setExpr("1+2");
        assertEquals((int)calc.findNumberInExpr(),1);
    }
}