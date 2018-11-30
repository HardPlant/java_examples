package com.seongwon.calc;


import org.junit.Test;
import static org.junit.Assert.*;

public class OperandTest{
    @Test
    public void plusTest(){
        Operand plus = new Plus(1,2);
        assertEquals((int)plus.run(), 3);

    }
}