package com.seongwon.calc;

import java.util.Queue;

public class Calculator{
    String expr;
    public Calculator(){
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
    

    /**
     * @param expr the expr to set
     */
    public void setExpr(String expr) {
        this.expr = expr;
    }
}