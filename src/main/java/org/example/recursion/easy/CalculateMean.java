package org.example.recursion.easy;

import java.util.Arrays;

public class CalculateMean {
    public static void main(String[] args) {
        CalculateMean calculateMean=new CalculateMean();
        double arr[]={1,2,3,4};
        System.out.println(calculateMean.calculate(arr));
    }

    public double calculate(double[] nums){
        if(nums.length==1)
            return nums[nums.length-1];
        else
            return ((calculate(Arrays.copyOf(nums,nums.length-1))*(nums.length-1)+nums[nums.length-1])/ nums.length);
    }
}

//Dry Run
//1,2,3,4 (2*3+4)/4=2.5
//1,2,3 (1.5*2+3)/3=2
//1,2 (1*1+2)/2=1.5
//1   1