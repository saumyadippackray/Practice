package org.example.dynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,3,3};
        HouseRobber houseRobber=new HouseRobber();
        System.out.println(houseRobber.rob(nums));
    }
    public int rob(int[] nums) {
        int[] cache=new int[nums.length];
        Arrays.fill(cache,-1);
        return maxDfs(nums,0,cache);
    }

    public int maxDfs(int[] nums,int i,int[] cache){
        if(i>=nums.length)
            return 0;
        if(cache[i]!=-1)
            return cache[i];
        return cache[i]=Math.max(maxDfs(nums,i+1,cache),nums[i]+maxDfs(nums,i+2,cache));
    }
}
