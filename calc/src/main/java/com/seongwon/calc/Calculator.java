package com.seongwon.calc;

import java.util.Queue;

public class Calculator{
    String expr;
    public Calculator(){
        queue = new String[100];
    }

    void simpleParse(){
        int first_index;
        int operand_index;
        int second_index;
        for(int i=0;i<expr.length();i++){
            char current = expr.charAt(i);
            if('0'< current && current <'9'){
                continue;
            }
            first_index = i;
            break;
        }

        for(int i=0;i<expr.length();i++){
            char current = expr.charAt(i);
            if(!('0'< current && current <'9')){
                continue;
            }
            operand = i;
        }

        for(int i=0;i<expr.length();i++){
            char current = expr.charAt(i);
            if('0'< current && current <'9'){
                continue;
            }
            second_index = i;
            break;
        }
        String first = expr.substring(0, first_index);
        String operand = expr.substring(first_index,operand_index);
        String second = expr.substring(operand_index, second_index);
        evaluate(operand, first, second);
    }
    public double evaluate(String operand, String first, String second){
        double operand1 = Double(first);
        double operand2 = Double(second);
        Operand operator;
        if(operand.equals('+')){
            operator = new Plus(operand1, operand2);
        }
        
        assert(operator != null);
        return operator.run();
    }
    

    /**
     * @param expr the expr to set
     */
    public void setExpr(String expr) {
        this.expr = expr;
    }
}