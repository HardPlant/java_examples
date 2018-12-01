package com.seongwon.calc;

import java.util.Queue;

public class Calculator{
    String expr;
    public Calculator(){
    }

    public int findParentheseExpr(){
        int start = 0;
        int end = 0;
        for(int i=0; i<expr.length();i++){
            int current = expr.charAt(i);
            if(current != '('){
                continue;
            } else{
                start = i;
                break;
            }
        }
        for(int i=start; i<expr.length();i++){
            int current = expr.charAt(i);
            if(current != ')'){
                continue;
            } else{
                end = i;
                break;
            }
        }

        return new Expression(expr.substring(start,end));
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(String expr) {
        this.expr = expr;
    }
}