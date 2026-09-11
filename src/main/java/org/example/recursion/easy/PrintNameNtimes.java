package org.example.recursion.easy;

public class PrintNameNtimes {

    public static void main(String[] args) {
        print(5);
    }
    public static void print(int n){
        if(n==0)
            return;

//        n=n-1;
        System.out.println("Suman");
        print(n-1);
    }
}
