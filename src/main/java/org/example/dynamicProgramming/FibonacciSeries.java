package org.example.dynamicProgramming;

import java.util.Arrays;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n=5;
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        FibonacciSeries fibonacciSeries=new FibonacciSeries();
        System.out.println(fibonacciSeries.fibonacciTabularFormat(n));
    }

    public int dfs(int n,int[] dp){
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=dfs(n-1,dp)+dfs(n-2,dp);
    }

    public int fibonacciTabularFormat(int n){
        int previous=1;
        int secondPrevious=0;

        for(int i=2;i<=n;i++){
            int sum=previous+secondPrevious;
            secondPrevious=previous;
            previous=sum;
        }
        return previous;
    }
}
