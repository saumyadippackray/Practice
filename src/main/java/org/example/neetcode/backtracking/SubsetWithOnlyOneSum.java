package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithOnlyOneSum {
    public static void main(String[] args) {
    subsetsWithOneSum(new int[]{3,1,2});
    }
        public static List<List<Integer>> subsetsWithOneSum(int[] nums) {
            List<List<Integer>> result=new ArrayList<>();
            List<Integer> subset=new ArrayList<>();
            getSubsetsWithOneSum(0,result,0,subset,nums,3);
            System.out.println(result);
            return result;
        }
        public static boolean getSubsetsWithOneSum(int index,List<List<Integer>> result,Integer subsetSum,List<Integer> subset,int[] nums,int sum){
            if(index>=nums.length){
                if(subsetSum==sum){
                    result.add(new ArrayList<>(subset));
                    return true;
                }
                else {
                    return false;
                }
            }

            //subsetSum=subsetSum+nums[index];
            subset.add(nums[index]);
            if(getSubsetsWithOneSum(index+1,result,subsetSum+nums[index],subset,nums,sum))
                return true;

            //subsetSum=subsetSum-subset.get(subset.size()-1);
            subset.remove(subset.size()-1);
            if(getSubsetsWithOneSum(index+1,result,subsetSum,subset,nums,sum))
                return true;

            return false;

        }
}
