package org.example.dynamicProgramming;

import java.util.Arrays;

public class FrogJumpWithKDistance {
    public static void main(String[] args) {
        int[] arr=new int[]{30,10,60,10,60,50};
        FrogJumpWithKDistance frogJumpWithKDistance=new FrogJumpWithKDistance();
        System.out.println(frogJumpWithKDistance.frogJumpBottomUp(arr,2));
    }

    public int frogJumpBottomUp(int[] heights, int k) {
        int[] dp=new int[heights.length];
        dp[0]=0;

        for(int i=1;i<heights.length;i++){
            int minStep=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int step=dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    minStep=Math.min(step,minStep);
                    dp[i]=minStep;
                }
            }
        }
        return dp[heights.length-1];
    }
    public int frogJump(int[] heights, int k) {
        int[] dp=new int[heights.length];
        Arrays.fill(dp,-1);
        return dfs(heights,k,heights.length-1,dp);
    }

    public int dfs(int[] heights, int k,int i,int[] dp){
        if(i==0)
            return 0;
        int minsteps=Integer.MAX_VALUE;
        if(dp[i]!=-1)
            return dp[i];
        for(int step=1;step<=k;step++){
            if(i-step>=0){
                int jump=dfs(heights,k,i-step,dp)+Math.abs(heights[i]-heights[i-step]);
                minsteps=Math.min(jump,minsteps);
            }
        }
        return dp[i]=minsteps;
    }
}
