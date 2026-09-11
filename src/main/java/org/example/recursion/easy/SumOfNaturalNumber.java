package org.example.recursion.easy;

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        SumOfNaturalNumber sumOfNaturalNumber=new SumOfNaturalNumber();
        System.out.println(sumOfNaturalNumber.sum(5));
    }

    int sum(int num){
        if (num==0)
            return 0;
        return num+sum(num-1);
    }
}
