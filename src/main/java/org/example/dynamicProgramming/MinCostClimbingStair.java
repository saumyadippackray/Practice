package org.example.dynamicProgramming;

import java.util.Arrays;

public class MinCostClimbingStair {
    public static void main(String[] args) {
        int[] cost={1,2,1,2,1,1,1};

        MinCostClimbingStair minCostClimbingStair=new MinCostClimbingStair();
        System.out.println(minCostClimbingStair.minCostClimbingStairsIterative(cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] cache=new int[cost.length];
        Arrays.fill(cache,-1);
        return Math.min(dfs(cost,0,cache),dfs(cost,1,cache));
    }

    public int dfs(int[] cost,int n,int[] cache){
        if(n>=cost.length)
            return 0;
        if(cache[n]!=-1)
            return cache[n];
        return cache[n]=cost[n]+Math.min(dfs(cost,n+1,cache),dfs(cost,n+2,cache));

    }

    public int minCostClimbingStairsIterative(int[] cost) {
        int prev2=cost[0];//1
        int prev1=cost[1];//2
//        1,2,1,2,1,1,1
        for(int i=2;i<cost.length;i++){
            int totalCost=cost[i]+Math.min(prev2,prev1);
            prev2=prev1;
            prev1=totalCost;
        }
        return Math.min(prev2,prev2);
    }
}
