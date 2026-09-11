package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithSum {
    public static void main(String[] args) {
        subsetsWithSum(new int[]{2,3,6,7});
    }
    public static List<List<Integer>> subsetsWithSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        getSubsetsWithSum(0,result,0,subset,nums,3);
        System.out.println(result);
        return result;
    }
    public static void getSubsetsWithSum(int index,List<List<Integer>> result,Integer subsetSum,List<Integer> subset,int[] nums,int sum){
        if(index>=nums.length)
        {
            if(subsetSum==sum)
                result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        subsetSum=subsetSum+nums[index];
        getSubsetsWithSum(index+1,result,subsetSum,subset,nums,sum);
        subsetSum=subsetSum- subset.get(subset.size()-1);
        subset.remove(subset.size()-1);
        getSubsetsWithSum(index+1,result,subsetSum,subset,nums,sum);

    }
}
