package org.example.recursion.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SumOfArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        SumOfArray sumOfArray=new SumOfArray();
        System.out.println(sumOfArray.sum(nums));
    }
    public int sum(int[] nums){
        if(nums.length==1)
            return nums[nums.length-1];
        else
            return sum(Arrays.copyOf(nums,nums.length-1))+nums[nums.length-1];
    }
}

//1 2 3 4 6+4
//1 2 3 3+3
//1 2 1+2
//1  1