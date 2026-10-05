package org.example.dynamicProgramming;

public class JumpGameII{

    public static void main(String[] args) {
        JumpGameII jumpGame=new JumpGameII();
        int nums[]=new int[]{2,3,1,1,4};
        System.out.println(jumpGame.jump(nums));
    }
    public int jump(int[] nums) {
        Boolean[] dp=new Boolean[nums.length];
        //Arrays.fill(dp,null);
        return dfs(nums,0,0);
    }

    public int dfs(int[] nums,int i,int sum){
        if(i==nums.length-1)
            return sum;

        sum=sum+1;
        for(int j=1;j<nums[i];j++){
            dfs(nums, i+j, sum);
        }
        sum=sum-1;
        return 0;
    }
}
