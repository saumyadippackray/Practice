package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        getCombinationSum(0,target,nums,result,combination);
        System.out.println(result);
        return result;
    }

    public static void getCombinationSum(int index,int target,int[] nums,List<List<Integer>> result,List<Integer> combination){
       if(target==0){
           result.add(new ArrayList<>(combination));
           return;
       }
        if(index>=nums.length){
            return;
        }
       if(nums[index]<=target){
           combination.add(nums[ index]);
           getCombinationSum(index,target-nums[index],nums,result,combination);
           combination.remove(combination.size()-1);
       }

       getCombinationSum(index+1,target,nums,result,combination);
    }

    public static void getCombinationSumNeetCode(int index,int target,int[] nums,List<List<Integer>> result,List<Integer> combination){
        if(target==0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if(target<0 || index>=nums.length){
            return;
        }


        combination.add(nums[index]);
        getCombinationSum(index,target-nums[index],nums,result,combination);
        combination.remove(combination.size()-1);
        getCombinationSum(index+1,target,nums,result,combination);
    }
}
