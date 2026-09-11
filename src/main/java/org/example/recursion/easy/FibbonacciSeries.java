package org.example.recursion.easy;

import java.util.List;

public class FibbonacciSeries {
    public static void main(String[] args) {
        FibbonacciSeries fibbonacciSeries=new FibbonacciSeries();
        System.out.println(fibbonacciSeries.getFibbonForParticularPosition(5));
    }

//    public List<Integer> fibbo(int count){
//        List<>
//    }
//
    public Integer getFibbonForParticularPosition(int num){
        if(num==0)
            return 0;
        else if(num==1)
            return 1;
        else
            return getFibbonForParticularPosition(num-1)+getFibbonForParticularPosition(num-2);
    }
}


//4 4 + 3
//3 2+1 1+1 1 2
//2 1+1 1 1+1
//1
//0

//0 1 1 2

