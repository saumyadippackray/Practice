package org.example.dynamicProgramming;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame jumpGame=new JumpGame();
        int nums[]=new int[]{2,3,1,1,4};
        System.out.println(jumpGame.canJump(nums));
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp=new Boolean[nums.length];
        //Arrays.fill(dp,null);
        return canJump(nums,0,dp);
    }

    public boolean canJump(int[] nums,int i,Boolean[] dp){
        if(i==nums.length-1)
            return true;
        if(dp[i]!=null)
            return dp[i];
        for(int j=1;j<=nums[i];j++){
           if(canJump(nums,i+j,dp))
               return dp[i]=true;
        }

        return dp[i]=false;
    }
}
