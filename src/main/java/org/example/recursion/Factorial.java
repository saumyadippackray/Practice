package org.example.recursion;

public class Factorial {
    public static void main(String[] args) {
        Factorial factorial=new Factorial();
        System.out.println(factorial.factorial(8));
    }

    public Integer factorial(Integer number){
        if(number==0)
            return 0;
        else if(number==1)
            return 1;
        else
            return number*factorial(number-1);
    }
}

// 5->5,4->4,3->3,2->2,1->1
