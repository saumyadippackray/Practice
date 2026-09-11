package org.example.recursion.easy;

public class PrintNto1 {
    public static void main(String[] args) {
        PrintNto1 printNto1=new PrintNto1();
        printNto1.print(5);
    }
    public void print(int n){
        if(n==0)
            return;
        System.out.println(n);
        print(n-1);
    }
}
