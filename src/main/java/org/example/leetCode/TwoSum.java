package org.example.leetCode;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int tempArray[]=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    tempArray[0]=i;
                    tempArray[1]=j;
                    break;
                }
            }
        }
        return tempArray;
    }

    public static void main(String[] args) {
        int nums[]={2,7,11,15};

    }
}
