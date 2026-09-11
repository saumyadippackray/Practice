package org.example.recursion.easy;

public class FibonacciSeriesReverse {
    public static void main(String[] args) {
        System.out.println(FibonacciSeriesReverse.fibbo(4));
    }
    public static int fibbo(int count){
        if(count==1)
            return 1;
        else if (count==0)
            return 0;
        else
            return fibbo(count-1)+fibbo(count-2);
    }
}

//Input: N = 5
//        Output: 3 2 1 1 0
//        Explanation: First five terms are - 0 1 1 2 3.
//
//        Input: N = 10
//        Output: 34 21 13 8 5 3 2 1 1 0
