package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,1}));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subsets=new ArrayList<>();
        Arrays.sort(nums);
        getSubsetWithoutDuplicate(0,nums,result,subsets);
        return result;
    }

    public static void getSubsetWithoutDuplicate(int index,int[] nums,List<List<Integer>> result,List<Integer> subsets){
        result.add(new ArrayList<>(subsets));

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1])
                continue;

            subsets.add(nums[i]);
            getSubsetWithoutDuplicate(i+1,nums,result,subsets);
            subsets.remove(subsets.size()-1);
        }
    }
}
