package com.seongwon.calc;

public class Expression{
    Operand operand;
    public Expression(String operand, int a, int b){

    }

    public Operand getOperandObject() {
        return operand;
    }


    public double evaluate(String operand, String first, String second){
        Integer operand1 = Integer.valueOf(first);
        Integer operand2 = Integer.valueOf(second);
        Operand operator = null;
        if(operand.equals("+")){
            operator = new Plus(operand1, operand2);
        }

        assert(operator != null);
        return operator.run();
    }
}