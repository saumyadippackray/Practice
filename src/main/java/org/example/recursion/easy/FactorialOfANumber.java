package org.example.recursion.easy;

public class FactorialOfANumber {
    public static void main(String[] args) {
        FactorialOfANumber factorialOfANumber=new FactorialOfANumber();
        System.out.println(factorialOfANumber.fact(4));
    }

    public int fact(int num){
        if(num==0)
            return 1;
        else
            return fact(num-1)*num;
    }
}
