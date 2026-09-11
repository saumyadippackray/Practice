package org.example.recursion;

public class RecursionExample {
    public static void printNumber(int n){
        if(n==0)
            return;
        System.out.println(n);
        n--;
        printNumber(n);
        System.out.println("suman");
    }
    public static void main(String[] args) {
        printNumber(10);
    }

}
