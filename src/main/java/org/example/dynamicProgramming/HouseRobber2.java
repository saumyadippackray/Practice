package org.example.dynamicProgramming;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,2};
        HouseRobber2 houseRobber2=new HouseRobber2();
        System.out.println(houseRobber2.robTabular(nums));
    }
    public int robTabular(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(robRange(nums,1,nums.length-1),robRange(nums,0,nums.length-2));
    }

    private int robRange(int[] nums, int start, int end) {
        int prev1=0;
        int prev2=0;

        for(int i=start;i<=end;i++){
            int take=nums[i];
            prev2=take+prev2;
            //prev1=prev1;
            int curr=Math.max(prev1,prev2);
            prev2= prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int[] dp=new int[nums.length-1];
        Arrays.fill(dp,-1);
        int arr1[]= new int[nums.length-1];
        int arr2[]=new int[nums.length-1];
        for(int i=0;i<nums.length;i++){
            if(i!=0)
                arr1[i-1]=nums[i];
            if(i!=nums.length-1)
                arr2[i]=nums[i];
        }
        return Math.max(dfs(arr1,arr1.length-1,dp),dfs(arr2,arr2.length-1,dp));
    }

    public int dfs(int[] nums,int i,int[] dp){
        if(i==0)
            return nums[i];

        if(i<0)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int sumPick=nums[i]+dfs(nums,i-2,dp);
        int sumNonPick=dfs(nums,i-1,dp);

        return dp[i]=Math.max(sumPick,sumNonPick);
    }
}
