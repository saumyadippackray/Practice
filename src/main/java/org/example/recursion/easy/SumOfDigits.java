package org.example.recursion.easy;

public class SumOfDigits {
    public static void main(String[] args) {
        SumOfDigits sumOfDigits=new SumOfDigits();
        System.out.println(sumOfDigits.sum(12345));
    }

    public int sum(int num){
        if(num==0)
            return 0;
        else
            return sum(num/10)+num%10;
    }
}

//1234
//123
//12
//1
