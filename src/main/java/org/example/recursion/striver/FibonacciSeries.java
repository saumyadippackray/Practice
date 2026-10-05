package org.example.recursion.striver;

public class FibonacciSeries {
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries=new FibonacciSeries();
        System.out.println(fibonacciSeries.dfs(5));
    }
    public int dfs(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return dfs(n-1)+dfs(n-2);

    }
}
