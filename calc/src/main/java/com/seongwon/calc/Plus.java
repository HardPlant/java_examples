package com.seongwon.calc;

public class Plus implements Operand{
    int a;
    int b;
    public Plus(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    @Override
    public double run() {
        return a+b;
    }   
}