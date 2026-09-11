package org.example.Sorting;

public class RecursionPractice {
    public static void main(String[] args) {
        recursion(10,10);
    }
    public static void recursion(int i,int j){
        if(i==0)
            return;
        if(j==0)
            return;
        System.out.println("i="+i+"j="+j);
        recursion(i-1,j);
        recursion(i,j-1);

    }
}
