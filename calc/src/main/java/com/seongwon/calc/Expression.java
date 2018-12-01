package com.seongwon.calc;

public class Expression{
    Operand operand;
    String expr;
    public Expression(String expr){
        this.expr = expr;
    }

    public Operand getOperandObject() {
        return operand;
    }

    public void evaluate(){

    }

    public int findNumberInExpr(){
        int start = 0;
        int end = 0;
        for(int i=0; i<expr.length();i++){
            int current = expr.charAt(i);
            if('0'<=current && current <='9'){
                continue;
            } else{
                end = i;
                break;
            }
        }
        return Integer.valueOf(expr.substring(start,end));
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