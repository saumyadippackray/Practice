package org.example.dynamicProgramming;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] nums=new int[]{2,1,4,9};
        MaximumSumOfNonAdjacentElements maximumSumOfNonAdjacentElements=new MaximumSumOfNonAdjacentElements();
        System.out.println(maximumSumOfNonAdjacentElements.nonAdjacentTabularWithoutDpArray(nums));
    }
    public int nonAdjacent(int[] nums) {
        int dp[]= new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums,nums.length-1,dp);
    }

    public int dfs(int[] nums,int i,int[] dp){
        if(i==0)
            return nums[i];
        if(i<0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int sumPick=nums[i]+dfs(nums,i-2,dp);
        int sumNotPick=0+dfs(nums,i-1,dp);

        return dp[i]=Math.max(sumPick,sumNotPick);
    }

    public int nonAdjacentTabular(int[] nums) {
        int dp[]= new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1)
                take=take+dp[i-2];
            int nonTake=0+dp[i-1];
            dp[i]=Math.max(take,nonTake);
        }
        return dp[dp.length-1];
    }
    public int nonAdjacentTabularWithoutDpArray(int[] nums) {
        int dp[]= new int[nums.length];
       // dp[0]=nums[0];
        int prev=nums[0];
        int secondPrev=0;
        for(int i=1;i<nums.length;i++){
            int take=nums[i];
            if(i>1)
                take=take+secondPrev;
            int nonTake=0+prev;
            secondPrev=prev;
            prev=Math.max(take,nonTake);
            System.out.println("take=="+take+"nonTake"+nonTake+"secondPrev"+secondPrev+"prev"+prev);
        }
        return prev;
    }
    //2 1 4 9

//            | Step | Current Element | `dp[i-2]` (or 0 if none) | `dp[i-1]` | `take` calculation | `nonTake` calculation | `dp[i] = Math.max(take, nonTake)` | DP Array State |
//            | --- | --- | --- | --- | --- | --- | --- | --- |
//            | **Init ($i=0$)** | `nums[0] = 2` | — | — | — | — | `dp[0] = 2` | `[2, 0, 0, 0]` |
//            | **$i = 1$** | `nums[1] = 1` | None ($i \ngtr 1$) | `dp[0] = 2` | `1` | `0 + dp[0] = 2` | $\max(1, 2) = 2$ | `[2, 2, 0, 0]` |
//            | **$i = 2$** | `nums[2] = 4` | `dp[0] = 2` | `dp[1] = 2` | `4 + dp[0] = 4 + 2 = 6` | `0 + dp[1] = 2` | $\max(6, 2) = 6$ | `[2, 2, 6, 0]` |
//            | **$i = 3$** | `nums[3] = 9` | `dp[1] = 2` | `dp[2] = 6` | `9 + dp[1] = 9 + 2 = 11` | `0 + dp[2] = 6` | $\max(11, 6) = 11$ | `[2, 2, 6, 11]` |
}
