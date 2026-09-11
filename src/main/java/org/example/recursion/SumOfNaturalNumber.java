package org.example.recursion;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        SumOfNaturalNumber sumOfNaturalNumber=new SumOfNaturalNumber();
        System.out.println(sumOfNaturalNumber.sum(7));
    }

    public int sum(int n){
        if(n==1)
            return n;
        if(n==0)
            return n;
        return n+sum(n-1);
    }
}
